import javax.swing.*;
import java.awt.*;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.CENTER;

public class MainWindow {

    public MainWindow() {

        //Creates a new board
        Board board = menu("HARD");
        board.fillWithBombs();

        //Sets the JFrame with the dimension of the board
        JFrame window = new JFrame("Minesweeper");
        /* NOTA PER IL FUTURO
        DISPOSE_ON_CLOSE chiude solo il frame a cui è associato, mentre EXIT_ON_CLOSE chiude tutti i frame
        esistenti e esce dal programma. DISPOSE_ON_CLOSE può essere utile se vogliamo dare l'opzione di chiudere
        la partita e tornare al menù principale. EXIT_ON_CLOSE serà la close operation di default per il menù
         */
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container cp = window.getContentPane();
        cp.setLayout(new GridBagLayout());

        int x = board.getWidth();
        int y = board.getLength();

        Cell[][] cellArray = new Cell[x][y];

        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getLength(); j++) {
                cellArray[i][j] = new Cell(0);
                cp.add(cellArray[i][j], new GridBagConstraints(i, j, 1, 1, 1.0, 1.0, CENTER, BOTH, new Insets(0, 0, 0, 0), 0, 0));
            }
        }
        window.setSize(x * 45, y * 45); //impostare la dimensione della finestra
        //Si potrebbe ridefinire mettendo grandezza variabile a seconda del campo che deve generare
        window.setVisible(true);
        window.setLocationRelativeTo(null); //fa si che l'eseguibile venga aperto al centro
        window.setResizable(false); //priva la ridimensione della pagina
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
                board = new Board(30, 16, 99);
                break;
            default:
                board = null;
        }
        return board;
    }


}
