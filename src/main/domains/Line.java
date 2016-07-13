package main.domains;


import java.util.List;

public class Line {
    private List<Block> blocks;
    private int length;

    public Line(List<Block> blocks, int length) {
        this.blocks = blocks;
        this.length = length;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public int size() {
        int size = 0;
        for (Block block: blocks) {
            size += block.getCells().size();
        }
        return size;
    }
}
