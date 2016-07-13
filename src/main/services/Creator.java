package main.services;


import main.domains.*;
import java.util.ArrayList;
import java.util.List;

public class Creator {

    public Grid init() {
        int height = 3;
        int width = 4;
        List<Row> rows = new ArrayList<>();
        List<Column> columns = new ArrayList<>();
        initRows(rows, width);
        initColumns(columns, height);
        return new Grid(width, height, rows, columns);
    }

    public Line cloneLine(Line line) {
        List<Block> clonedBlocks = new ArrayList<>();
        for (Block block: line.getBlocks()){
            List<Cell> clonedCells = new ArrayList<>();
            Block clonedBlock = new Block();
            for (Cell cell: block.getCells()){
                Cell clonedCell = new Cell();
                clonedCells.add(clonedCell);
            }
            clonedBlock.setCells(clonedCells);
            clonedBlocks.add(clonedBlock);
        }
        Line clonedLine = new Line(clonedBlocks, line.getLength());
        return clonedLine;
    }

    private void initRows(List<Row> rows, int width){
        List<Cell> cells11 = new ArrayList<>();
        List<Cell> cells12 = new ArrayList<>();
        Cell cell111 = new Cell();
        Cell cell112 = new Cell();
        Cell cell121 = new Cell();
        cells11.add(cell111);
        cells11.add(cell112);
        cells12.add(cell121);
        Block block11 = new Block();
        block11.setCells(cells11);
        Block block12 = new Block();
        block12.setCells(cells12);
        List<Block> blocks1 = new ArrayList<>();
        blocks1.add(block11);
        blocks1.add(block12);
        Row row1 = new Row(blocks1, width);

        List<Cell> cells21 = new ArrayList<>();
        Cell cell211 = new Cell();
        Cell cell212 = new Cell();
        Cell cell213 = new Cell();
     //   Cell cell214 = new Cell();
        cells21.add(cell211);
        cells21.add(cell212);
        cells21.add(cell213);
       // cells21.add(cell214);
        Block block21 = new Block();
        block21.setCells(cells21);
        List<Block> blocks2 = new ArrayList<>();
        blocks2.add(block21);
        Row row2 = new Row(blocks2, width);

        List<Cell> cells31 = new ArrayList<>();
        Cell cell311 = new Cell();
        cells31.add(cell311);
        Block block31 = new Block();
        block31.setCells(cells31);
        List<Block> blocks3 = new ArrayList<>();
        blocks3.add(block31);
        Row row3 = new Row(blocks3, width);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
    }

    private void initColumns(List<Column> columns, int width){
        List<Cell> cells11 = new ArrayList<>();
        Cell cell111 = new Cell();
        cells11.add(cell111);
        Block block11 = new Block();
        block11.setCells(cells11);
        List<Block> blocks1 = new ArrayList<>();
        blocks1.add(block11);
        Column column1 = new Column(blocks1, width);

        List<Cell> cells21 = new ArrayList<>();
        Cell cell211 = new Cell();
        Cell cell212 = new Cell();
        cells11.add(cell211);
        cells11.add(cell212);
        Block block21 = new Block();
        block11.setCells(cells21);
        List<Block> blocks2 = new ArrayList<>();
        blocks2.add(block21);
        Column column2 = new Column(blocks2, width);

        List<Cell> cells31 = new ArrayList<>();
        Cell cell311 = new Cell();
        cells11.add(cell311);
        Block block31 = new Block();
        block11.setCells(cells31);
        List<Block> blocks3 = new ArrayList<>();
        blocks3.add(block31);
        Column column3 = new Column(blocks3, width);

        List<Cell> cells41 = new ArrayList<>();
        List<Cell> cells42 = new ArrayList<>();
        Cell cell411 = new Cell();
        Cell cell421 = new Cell();
        cells41.add(cell411);
        cells42.add(cell421);
        Block block41 = new Block();
        block11.setCells(cells41);
        Block block42 = new Block();
        block42.setCells(cells42);
        List<Block> blocks4 = new ArrayList<>();
        blocks4.add(block41);
        blocks4.add(block42);
        Column column4 = new Column(blocks4, width);

        columns.add(column1);
        columns.add(column2);
        columns.add(column3);
        columns.add(column4);
    }
}
