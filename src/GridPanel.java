import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GridPanel extends JPanel {

    private Grid grid;

    private final int CELL_SIZE = 30;

    public GridPanel(Grid grid) {

        this.grid = grid;

        setPreferredSize(
                new Dimension(
                        grid.getSize()*CELL_SIZE,
                        grid.getSize()*CELL_SIZE
                )
        );
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        char[][] cells = grid.getGrid();

        List<Position> path = grid.getShortestPath();

        for(int r=0; r<grid.getSize(); r++) {

            for(int c=0; c<grid.getSize(); c++) {

                boolean isPath = false;

                for(Position p : path) {

                    if(p.row == r && p.col == c) {

                        isPath = true;
                        break;
                    }
                }

                if(isPath && cells[r][c] != 'A' && cells[r][c] != 'T') {

                    g.setColor(Color.YELLOW);
                }
                else {

                    switch(cells[r][c]) {

                        case 'X':
                            g.setColor(Color.BLACK);
                            break;

                        case 'A':
                            g.setColor(Color.BLUE);
                            break;

                        case 'T':
                            g.setColor(Color.GREEN);
                            break;

                        case 'D':
                            g.setColor(Color.RED);
                            break;

                        default:
                            g.setColor(Color.WHITE);
                    }
                }

                g.fillRect(
                        c*CELL_SIZE,
                        r*CELL_SIZE,
                        CELL_SIZE,
                        CELL_SIZE
                );

                g.setColor(
                        Color.GRAY
                );

                g.drawRect(
                        c*CELL_SIZE,
                        r*CELL_SIZE,
                        CELL_SIZE,
                        CELL_SIZE
                );
            }
        }
    }
}