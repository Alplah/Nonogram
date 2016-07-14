package main.services;


import main.domains.*;

import java.util.List;

public class Solver {
    private Creator creator = new Creator();

    public void solve(Grid grid) {
        int gridWidth = grid.getWidth();
        solveRows(grid, gridWidth);
        solveColumns(grid, gridWidth);
    }
    
    private void solveLine(Line line, int gridWidth) {
        if (line.size() > 0.5 * gridWidth) {
            List<Block> blocks = line.getBlocks();
            int startIndex = 0;
            for (Block block : blocks) {
                block.setStartIndex(startIndex);
                startIndex += block.getSize() + 1;
            }
            startIndex = gridWidth;
            Line reverseRow = creator.cloneLine(line);
            List<Block> reverseBlocks = reverseRow.getBlocks();
            for (int j = reverseBlocks.size() - 1; j >= 0; j--) {
                Block block = reverseBlocks.get(j);
                block.setStartIndex(startIndex - block.getSize());
                startIndex -= block.getSize() + 1;
            }
            calculateDelta(line, reverseRow);
        }
    }

    private void solveRows(Grid grid, int gridWidth) {
        for (Row row : grid.getRows()) {
            solveLine(row, gridWidth);
        }
    }

    private void solveColumns(Grid grid, int gridWidth) {
        for (Column column : grid.getColumns()) {
            solveLine(column, gridWidth);
        }
    }

    private void calculateDelta(Line row, Line reverseRow) {
        for (int i = 0; i <= row.getBlocks().size() - 1; i++) {
            Block block = row.getBlocks().get(i);
            Block reverseBlock = reverseRow.getBlocks().get(i);
            int delta = block.getStartIndex() + block.getSize() - reverseBlock.getStartIndex();
            if (delta >= 0) {
                for (int j = delta; j > 0; j--) {
                    Cell cell = block.getCells().get(block.getSize() - j);
                    cell.setFilled(true);
                    cell.setSolved(true);
                }
            }
        }
    }
}
