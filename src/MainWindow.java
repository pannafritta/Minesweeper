import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.CENTER;

public class MainWindow {

    public MainWindow() {

        //Creates a new board
        Board board = menu("EASY");

        //Sets the JFrame with the dimension of the board
        JFrame frame = new JFrame("Minesweeper");
        /* NOTA PER IL FUTURO
        DISPOSE_ON_CLOSE chiude solo il frame a cui è associato, mentre EXIT_ON_CLOSE chiude tutti i frame
        esistenti e esce dal programma. DISPOSE_ON_CLOSE può essere utile se vogliamo dare l'opzione di chiudere
        la partita e tornare al menù principale. EXIT_ON_CLOSE serà la close operation di default per il menù
         */
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.setLayout(new GridBagLayout());

        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getLength(); j++) {
                Cell cell = board.getCellArray()[i][j];
                cell.setCoordinates(i, j);
                cp.add(board.getCellArray()[i][j], new GridBagConstraints(i, j, 1, 1, 1.0, 1.0, CENTER, BOTH, new Insets(0, 0, 0, 0), 0, 0));
                cell.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (board.checkFirstClick(cell)){
                            System.out.printf("Cella: %d, %d; Prossimità: %d; Scritta: %s%n", cell.getGridX(), cell.getGridY(), cell.getProximity(), cell.getText());
                        } else {
                            System.out.println("Primo click! Genero la tabella!");
                            board.fillWithBombs(cell.getGridX(), cell.getGridY()); // genera la tabella non mettendo una bomba sul primo click
                        };
                    }
                });
            }
        }
        frame.setSize(board.getWidth() * 45, board.getLength() * 45); //impostare la dimensione della finestra
        //Si potrebbe ridefinire mettendo grandezza variabile a seconda del campo che deve generare
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //fa si che l'eseguibile venga aperto al centro
        frame.setResizable(false); //priva la ridimensione della pagina -> meglio renderla resizable in futuro
    }

    public Board menu(String mode) {
        Board board;
        switch (mode) {
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
