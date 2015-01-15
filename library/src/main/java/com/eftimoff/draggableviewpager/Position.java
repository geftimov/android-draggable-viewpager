package com.eftimoff.draggableviewpager;

public class Position {

    private int row;
    private int column;
    private int page;

    public Position() {
    }

    public Position(int row, int column, int page) {
        this.row = row;
        this.column = column;
        this.page = page;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
