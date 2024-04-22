public class Minesweeper {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ProvaGUI.createAndShowGUI();
            }
        });
    }

}