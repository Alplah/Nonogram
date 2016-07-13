package main.domains;


import java.util.List;

public class Grid {
    private List<Row> rows;
    private List<Column> columns;
    private final int width;
    private final int height;

    public Grid(int width, int height, List<Row> rows, List<Column> columns) {
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.columns = columns;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
