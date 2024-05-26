import javax.swing.JFrame;

public class Aplicacao {
        public static void main(String[] args) {
        ConversorCF cv = new ConversorCF("Conversor C-F");
        cv.setVisible(true);
        cv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
