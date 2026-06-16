import javax.swing.*;

public class GridFrame extends JFrame {

    public GridFrame(Grid grid) {

        setTitle("NeuroVector Intelligence");

        add(new GridPanel(grid));

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }
}