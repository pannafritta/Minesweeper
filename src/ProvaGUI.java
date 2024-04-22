import javax.swing.*;

public class ProvaGUI {
    protected static void createAndShowGUI() {
        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Ciao mondo, io invece sono un'interfaccia!");
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);
    }
    

}