package com.eftimoff.draggableviewpager;

public interface ViewPagerContainer {

    /**
     * Scrolls directly to specified page
     *
     * @param page index
     */
    public void scrollToPage(int page);


    /**
     * Scrolls to the page at left of current page
     */
    public void scrollLeft();

    /**
     * Scrolls to the page at right of current page
     */
    public void scrollRight();

    /**
     * Returns the current displayed page
     *
     * @return page index
     */
    public int currentPage();

    /**
     * Enable scrolling
     */
    public void enableScroll();

    /**
     * Disable scrolling
     */
    public void disableScroll();

    /**
     * Returns true if there is a page at right of current page
     *
     * @return
     */
    public boolean canScrollToNextPage();

    /**
     * Returns true if there is a page at left of current page
     *
     * @return
     */
    public boolean canScrollToPreviousPage();
}
