package com.eftimoff.draggableviewpager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleDraggableViewPagerAdapter implements DraggableViewPagerAdapter {

    List<Page> pages = new ArrayList<Page>();
    private Context context;
    private DraggableViewPager gridview;

    public ExampleDraggableViewPagerAdapter(Context context, DraggableViewPager gridview) {
        super();
        this.context = context;
        this.gridview = gridview;

        Page page1 = new Page();
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(1, "Item 1", R.drawable.ic_launcher));
        items.add(new Item(2, "Item 2", R.drawable.ic_launcher));
        items.add(new Item(3, "Item 3", R.drawable.ic_launcher));
        page1.setItems(items);
        pages.add(page1);

        Page page2 = new Page();
        items = new ArrayList<Item>();
        items.add(new Item(4, "Item 4", R.drawable.ic_launcher));
        items.add(new Item(5, "Item 5", R.drawable.ic_launcher));
        items.add(new Item(6, "Item 6", R.drawable.ic_launcher));
        items.add(new Item(7, "Item 7", R.drawable.ic_launcher));
        items.add(new Item(8, "Item 8", R.drawable.ic_launcher));
        items.add(new Item(9, "Item 9", R.drawable.ic_launcher));
        page2.setItems(items);
        pages.add(page2);

        Page page3 = new Page();
        items = new ArrayList<Item>();
        items.add(new Item(10, "Item 10", R.drawable.ic_launcher));
        items.add(new Item(11, "Item 11", R.drawable.ic_launcher));
        items.add(new Item(12, "Item 12", R.drawable.ic_launcher));
        items.add(new Item(13, "Item 13", R.drawable.ic_launcher));
        items.add(new Item(14, "Item 14", R.drawable.ic_launcher));
        items.add(new Item(15, "Item 15", R.drawable.ic_launcher));
        items.add(new Item(16, "Item 16", R.drawable.ic_launcher));
        items.add(new Item(17, "Item 17", R.drawable.ic_launcher));
        items.add(new Item(18, "Item 18", R.drawable.ic_launcher));
        items.add(new Item(19, "Item 19", R.drawable.ic_launcher));
        items.add(new Item(20, "Item 20", R.drawable.ic_launcher));
        items.add(new Item(21, "Item 21", R.drawable.ic_launcher));
        items.add(new Item(22, "Item 22", R.drawable.ic_launcher));
        items.add(new Item(23, "Item 23", R.drawable.ic_launcher));
        items.add(new Item(24, "Item 24", R.drawable.ic_launcher));
        items.add(new Item(25, "Item 25", R.drawable.ic_launcher));
        items.add(new Item(26, "Item 26", R.drawable.ic_launcher));
        items.add(new Item(27, "Item 27", R.drawable.ic_launcher));
        items.add(new Item(28, "Item 28", R.drawable.ic_launcher));
        items.add(new Item(29, "Item 29", R.drawable.ic_launcher));
        items.add(new Item(30, "Item 30", R.drawable.ic_launcher));
        items.add(new Item(31, "Item 31", R.drawable.ic_launcher));
        items.add(new Item(32, "Item 32", R.drawable.ic_launcher));
        items.add(new Item(33, "Item 33", R.drawable.ic_launcher));
        items.add(new Item(34, "Item 34", R.drawable.ic_launcher));
        items.add(new Item(35, "Item 35", R.drawable.ic_launcher));
        items.add(new Item(36, "Item 36", R.drawable.ic_launcher));
        items.add(new Item(37, "Item 37", R.drawable.ic_launcher));
        items.add(new Item(38, "Item 38", R.drawable.ic_launcher));
        items.add(new Item(39, "Item 39", R.drawable.ic_launcher));
        items.add(new Item(40, "Item 40", R.drawable.ic_launcher));
        items.add(new Item(41, "Item 41", R.drawable.ic_launcher));
        items.add(new Item(42, "Item 42", R.drawable.ic_launcher));
        items.add(new Item(43, "Item 43", R.drawable.ic_launcher));
        items.add(new Item(44, "Item 44", R.drawable.ic_launcher));
        items.add(new Item(45, "Item 45", R.drawable.ic_launcher));
        items.add(new Item(46, "Item 46", R.drawable.ic_launcher));
        items.add(new Item(47, "Item 47", R.drawable.ic_launcher));
        items.add(new Item(48, "Item 48", R.drawable.ic_launcher));
        items.add(new Item(49, "Item 49", R.drawable.ic_launcher));
        items.add(new Item(50, "Item 50", R.drawable.ic_launcher));
        items.add(new Item(51, "Item 51", R.drawable.ic_launcher));
        page3.setItems(items);
        pages.add(page3);

        Page page4 = new Page();
        items = new ArrayList<Item>();
        items.add(new Item(46, "Item 46", R.drawable.ic_launcher));

        page4.setItems(items);
        pages.add(page4);
    }

    @Override
    public int pageCount() {
        return pages.size();
    }

    private List<Item> itemsInPage(int page) {
        if (pages.size() > page) {
            return pages.get(page).getItems();
        }
        return Collections.emptyList();
    }

    @Override
    public View view(int page, int index) {
        final LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.my_text_view, null);
        final TextView textView = (TextView) view.findViewById(R.id.info_text);
        Item item = getItem(page, index);
        textView.setText(item.getName());
        return view;
    }

    private Item getItem(int page, int index) {
        List<Item> items = itemsInPage(page);
        return items.get(index);
    }

    @Override
    public int rowCount() {
        return -1;
    }

    @Override
    public int columnCount() {
        return 1;
    }

    @Override
    public int itemCountInPage(int page) {
        return itemsInPage(page).size();
    }

    public void printLayout() {
        int i = 0;
        for (Page page : pages) {
            Log.d("Page", Integer.toString(i++));

            for (Item item : page.getItems()) {
                Log.d("Item", Long.toString(item.getId()));
            }
        }
    }

    private Page getPage(int pageIndex) {
        return pages.get(pageIndex);
    }

    @Override
    public void swapItems(int pageIndex, int itemIndexA, int itemIndexB) {
        getPage(pageIndex).swapItems(itemIndexA, itemIndexB);
    }

    @Override
    public void moveItemToPreviousPage(int pageIndex, int itemIndex) {
        int leftPageIndex = pageIndex - 1;
        if (leftPageIndex >= 0) {
            Page startpage = getPage(pageIndex);
            Page landingPage = getPage(leftPageIndex);

            Item item = startpage.removeItem(itemIndex);
            landingPage.addItem(item);
        }
    }

    @Override
    public void moveItemToNextPage(int pageIndex, int itemIndex) {
        int rightPageIndex = pageIndex + 1;
        if (rightPageIndex < pageCount()) {
            Page startpage = getPage(pageIndex);
            Page landingPage = getPage(rightPageIndex);

            Item item = startpage.removeItem(itemIndex);
            landingPage.addItem(item);
        }
    }

    @Override
    public void deleteItem(int pageIndex, int itemIndex) {
        getPage(pageIndex).deleteItem(itemIndex);
    }


    @Override
    public int getPageWidth(int page) {
        return 0;
    }

    @Override
    public Object getItemAt(int page, int index) {
        return getPage(page).getItems().get(index);
    }

    @Override
    public boolean disableZoomAnimationsOnChangePage() {
        return false;
    }
}
