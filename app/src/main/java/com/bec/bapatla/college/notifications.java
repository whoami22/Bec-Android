package com.bec.bapatla.college;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class notifications extends AppCompatActivity {
    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference notifications1 = ref.child("notice");
    DatabaseReference notifications2 = ref.child("notice2");
    DatabaseReference notifications3 = ref.child("notice3");
    static String[] notes;
    static ArrayList<String> notificationData = new ArrayList<String>();

   // static String[] keyVal1 = {"CIRCULARS", "\nPlease Connect To Internet And Click on Refresh For CIRCULARS"};

    @Override
    protected void onStart() {
        super.onStart();
        //notificationData.clear();
        notificationData.clear();
        ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.extendlist);
        expandableListView.setVisibility(View.VISIBLE);
        notifications1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String m = dataSnapshot.getValue(String.class);
                //Log.d("STRING FROM DB", m);
                //keyVal = m.split(",");
                notificationData.add(m);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        notifications2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String m = dataSnapshot.getValue(String.class);
                //Log.d("STRING FROM DB", m);
                //keyVal = m.split(",");
                notificationData.add(m);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        notifications3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String m = dataSnapshot.getValue(String.class);
                //Log.d("STRING FROM DB", m);
                //keyVal = m.split(",");
                notificationData.add(m);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarsa);
        setSupportActionBar(toolbar);
       // notificationData.add("NOTIFICATIONS,\nPlease Connect To Internet And Click on Refresh For Latest Notifications");
        //notificationData.add("CIRCULARS,\nPlease Connect To Internet And Click on Refresh For Latest CIRCULARS");
        //notificationData.add("WORKSHOPS,\nPlease Connect To Internet And Click on Refresh For Latest WORKSHOP DETAILS");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.homebut);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // recreate();
                listAdapter = null;
                simpleExpandableListView.setAdapter(listAdapter);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                    }
                }, 500);
            }

        });
        if(isNetworkStatusAvialable (getApplicationContext())) {
            Toast.makeText(getApplicationContext(), "Connected To Internet\n Please Click Refresh to Get Notifications ", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "No Internet Connection\n Please Connect to Internet to Get Notifications", Toast.LENGTH_LONG).show();

        }
        // add data for displaying in expandable list view
        loadData();
        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) findViewById(R.id.extendlist);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(this, deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);

        //expand all the Groups
        expandAll();

        // setOnChildClickListener listener for child row click
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //get the child info
                ChildInfo detailInfo = headerInfo.getProductList().get(childPosition);
                //display it or do something with it
                // Toast.makeText(getBaseContext(), " Clicked on : " + headerInfo.getName()
                //        + "/" + detailInfo.getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //display it or do something with it
                //  Toast.makeText(getBaseContext(), " Header is : " + headerInfo.getName(),
                //        Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }
    public static boolean isNetworkStatusAvialable (Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null)
                if(netInfos.isConnected())
                    return true;
        }
        return false;
    }
    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.expandGroup(i);
        }
    }

    //method to collapse all groups
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            simpleExpandableListView.collapseGroup(i);
        }
    }

    //load some initial data into out list
    private void loadData() {
        for(String data : notificationData)
        {
            notes = data.split(",");
            String[] msg = notes[1].split("!");
            for(int i=0;i<msg.length;i++)
                addProduct(notes[0],msg[i]);
        }
        addProduct("Bank Circulars", getResources().getText(R.string.bankdetails).toString());
    }


    //here we maintain our products in various departments
    private int addProduct(String department, String product) {

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if (headerInfo == null) {
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }
}
