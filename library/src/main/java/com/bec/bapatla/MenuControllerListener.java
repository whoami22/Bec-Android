package com.bec.bapatla;

interface MenuControllerListener {

    void onOpenAnimationStart();

    void onOpenAnimationEnd();

    void onCloseAnimationStart();

    void onCloseAnimationEnd();

    void onSelectAnimationStart(CircleMenuButton menuButton);

    void onSelectAnimationEnd(CircleMenuButton menuButton);

    void redrawView();
}
