import javax.swing.*;
import java.awt.*;

public class ProvaGUI {

    protected static void createAndShowGUI() {

        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon tick = new ImageIcon("Tick.png");
        ImageIcon cross = new ImageIcon("Cross.png");

        JButton btn = new JButton("Click me!");
        JButton tickBtn = new JButton(tick);
        JButton crossBtn = new JButton("STOP", cross);

        JPanel pnl1 = new JPanel();
        pnl1.setBackground(Color.yellow);

        JPanel pnl2 = new JPanel();
        pnl2.setBackground(Color.blue);

        frame.add(pnl1);
        // frame.add(pnl2);

        pnl1.add(btn);
        pnl1.add(tickBtn);
        pnl1.add(crossBtn);

        JLabel label = new JLabel(String.valueOf("Evviva, sono una finestra!"));
        pnl1.add(label);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}