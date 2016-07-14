package main;

import main.domains.Block;
import main.domains.Cell;
import main.domains.Grid;
import main.domains.Row;
import main.services.Creator;
import main.services.Solver;

import java.util.List;

public class Nonogram {

    public static void main(String[] args) {
        Creator creator = new Creator();
        Grid grid = creator.init();
        Nonogram nonogram = new Nonogram();
        new Solver().solve(grid);
        nonogram.draw(grid);
    }

    public void draw(Grid grid) {
        int gridWidth = grid.getWidth();
        for (Row row : grid.getRows()) {
            List<Block> blocks = row.getBlocks();
            int blockIndex = 0;
            Block block = blocks.get(blockIndex);
            for (int i = 0; i <= gridWidth - 1; ) {
                if (blockIndex <= blocks.size() - 1) {
                    if (blockIndex > 0) {
                        block = blocks.get(blockIndex);
                    }
                }
                if (i == block.getStartIndex()) {
                    drawBlock(block);
                    i += block.getSize();
                    blockIndex++;
                    if (block.getStartIndex() == gridWidth - block.getSize()){
                        break;
                    }
                } else {
                    i++;
                    System.out.print((char) 9633);
                }
            }
            System.out.println("");
        }
    }

    private void drawBlock(Block block) {
        for (int j = 0; j < block.getSize(); j++) {
            Cell cell = block.getCells().get(j);
            if (cell.isFilled() && cell.isSolved()) {
                System.out.print((char) 9632);
            } else {
                System.out.print("?");
            }
        }
    }
}



