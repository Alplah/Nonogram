package main.domains;


import java.util.List;

public class Block {
    private List<Cell> cells;
    private int startIndex;

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getSize(){
       return getCells().size();
    }
}
