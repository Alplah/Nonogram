package main.services;


import main.domains.Block;
import main.domains.Grid;
import main.domains.Line;
import main.domains.Row;

import java.util.List;

public class Solver {
    private Creator creator = new Creator();

    public void solve(Grid grid) {
        int gridWidth = grid.getWidth();
        for (Row row : grid.getRows()) {
            if (row.size() > 0.5 * gridWidth) {
                List<Block> blocks = row.getBlocks();
                int startIndex = 0;
                for (Block block: blocks){
                    block.setStartIndex(startIndex);
                    startIndex += block.getSize() + 1;
                }
                Line reverseRow = creator.cloneLine(row);
                List<Block> reverseBlocks = reverseRow.getBlocks();
                for(int j = reverseBlocks.size() - 1; j >= 0; j--){
                    Block block = reverseBlocks.get(j);
                    block.setStartIndex(gridWidth - 1);
                    startIndex -= block.getSize() - 1;
                }
            }
        }
    }
}
