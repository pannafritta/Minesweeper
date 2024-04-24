import javax.swing.*;
import java.awt.*;

public class MainWindow {

    public MainWindow() {
        //Creates a new board
        Board board = new Board("easy");

        //Sets the JFrame with the dimension of the board
        JFrame window = new JFrame();
        window.setTitle("MineSweeper");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(board.getWidth() * 50, board.getLength() * 50);
        window.setLocationRelativeTo(null);

        //creates the buttons and adds them to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        window.add(panel, BorderLayout.CENTER);
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(board.getWidth(), board.getLength()));
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getLength(); j++) {
                panel.add(new Button(String.valueOf(board.getBoard()[i][j].getProximity())));
            }
        }
        window.setVisible(true);
    }


}
