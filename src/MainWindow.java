import javax.swing.*;
import java.awt.*;

public class MainWindow {

    public MainWindow() {

        //Creates a new board
        Board board = menu("EASY");
        board.fillWithBombs();

        //Sets the JFrame with the dimension of the board
        JFrame window = new JFrame("Minesweeper");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /* NOTA PER IL FUTURO
        DISPOSE_ON_CLOSE chiude solo il frame a cui è associato, mentre EXIT_ON_CLOSE chiude tutti i frame
        esistenti e esce dal programma. DISPOSE_ON_CLOSE può essere utile se vogliamo dare l'opzione di chiudere
        la partita e tornare al menù principale. EXIT_ON_CLOSE serà la close operation di default per il menù
         */
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
                panel.add(new Button(String.valueOf(board.getCellArray()[i][j].getProximity())));
            }
        }

        window.setVisible(true);
    }

    public Board menu(String op) {
        Board board;
        switch (op) {
            case "EASY":
                board = new Board(9, 9, 10);
                break;

            case "MEDIUM":
                board = new Board(16, 16, 40);
                break;

            case "HARD":
                board = new Board(30, 30, 99);
                break;
            default:
                board = null;
        }
        return board;
    }


}
