package com.eftimoff.draggableviewpager;

public interface PageChangerListener {

    void swipeToPage(final int page);

    void startSwiping();

    void stopSwiping();

}
