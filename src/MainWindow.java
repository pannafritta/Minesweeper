import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        // creates new board
        Board board = new Board("easy");

        //Sets the JFrame with the dimension of the board
        setTitle("MineSweeper");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(board.getWidth() * 50, board.getLength() * 50);
        setLocationRelativeTo(null);

        //creates the buttons and adds them to the board
        board.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        add(board, BorderLayout.CENTER);
        board.setBackground(Color.lightGray);
        board.setLayout(new GridLayout(board.getWidth(), board.getLength()));
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getLength(); j++) {
                board.add(new Button(String.valueOf(board.getBoard()[i][j].getProximity())));
            }
        }
        setVisible(true);
    }


}
