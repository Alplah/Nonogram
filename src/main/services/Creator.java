package main.services;


import main.domains.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Creator {

    public Grid init() {
        int height = 9;
        int width = 9;
        List<Row> rows = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        readAndInitData(height, width, rows, columns);
        return new Grid(width, height, rows, columns);
    }

    private void readAndInitData(int height, int width, List<Row> rows, List<Column> columns) {
        String fileName = "c://nonogram.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> lines = stream.collect(Collectors.toList());
            int i = 1;
            for (String line: lines) {
                String[] blocks = line.split(" ");
                if (i <= height) {
                    initRow(rows, blocks, width);
                } else {
                    initColumn(columns, blocks, width);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Block> initBlocks(String[] lineBlocks) {
        List<Block> blocks = new ArrayList<>();
        for (String lineBlock : lineBlocks) {
            List<Cell> cells = new ArrayList<>();
            Block block = new Block();
            for (int i = 0; i < Integer.parseInt(lineBlock); i++) {
                Cell cell = new Cell();
                cells.add(cell);
            }
            block.setCells(cells);
            blocks.add(block);
        }
        return blocks;
    }

    private void initRow(List<Row> rows, String[] lineBlocks, int width) {
        Row row = new Row(initBlocks(lineBlocks), width);
        rows.add(row);
    }

    private void initColumn(List<Column> columns, String[] lineBlocks, int width) {
        Column column = new Column(initBlocks(lineBlocks), width);
        columns.add(column);
    }

    public Line cloneLine(Line line) {
        List<Block> clonedBlocks = new ArrayList<>();
        for (Block block : line.getBlocks()) {
            List<Cell> clonedCells = new ArrayList<>();
            Block clonedBlock = new Block();
            for (Cell cell : block.getCells()) {
                Cell clonedCell = new Cell();
                clonedCells.add(clonedCell);
            }
            clonedBlock.setCells(clonedCells);
            clonedBlocks.add(clonedBlock);
        }
        Line clonedLine = new Line(clonedBlocks, line.getLength());
        return clonedLine;
    }
}
