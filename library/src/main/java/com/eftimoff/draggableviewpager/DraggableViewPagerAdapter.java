package com.eftimoff.draggableviewpager;

import android.view.View;

public interface DraggableViewPagerAdapter {

    /**
     * Used to create the paging
     *
     * @return the page count
     */
    public int pageCount();

    /**
     * Returns the count of item in a page
     *
     * @param page index
     * @return item count for page
     */
    public int itemCountInPage(int page);

    /**
     * Returns the view for the item in the page
     *
     * @param page index
     * @return the view
     */
    public View view(int page, int index);

    /**
     * The fixed row count (AUTOMATIC for automatic computing)
     *
     * @return row count or AUTOMATIC
     */
    public int rowCount();

    /**
     * The fixed column count (AUTOMATIC for automatic computing)
     *
     * @return column count or AUTOMATIC
     */
    public int columnCount();

    /**
     * Prints the layout in Log.d();
     * TODO Remove this.
     */
    public void printLayout();

    /**
     * Swaps two items in the item list in a page
     *
     * @param pageIndex
     * @param itemIndexA
     * @param itemIndexB
     */
    public void swapItems(int pageIndex, int itemIndexA, int itemIndexB);

    /**
     * Moves an item in the page on the left of provided the page
     *
     * @param pageIndex
     * @param itemIndex
     */
    public void moveItemToPreviousPage(int pageIndex, int itemIndex);

    /**
     * Moves an item in the page on the right of provided the page
     *
     * @param pageIndex
     * @param itemIndex
     */
    public void moveItemToNextPage(int pageIndex, int itemIndex);


    /**
     * deletes the item in page and at position
     *
     * @param pageIndex
     * @param itemIndex
     */
    public void deleteItem(int pageIndex, int itemIndex);


    /**
     * Tells the grid, the page defined width
     * If page width is zero, display width is taken
     *
     * @return the page width
     */
    public int getPageWidth(int page);

    /**
     * Gets the item displayed by the datasource
     *
     * @param page  the page we are looking at
     * @param index the index of the datasource
     * @return your object
     */
    public Object getItemAt(int page, int index);

    /**
     * Tells the grid to disable the zoom animation on change page
     */
    public boolean disableZoomAnimationsOnChangePage();


}
