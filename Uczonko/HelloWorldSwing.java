import javax.swing.*;
public class HelloWorldSwing {
    private static void createAndShowGUI() {
        // nowe okno o tytule HelloWorldSwing
        JFrame frame = new JFrame("HelloWorldSwing");
        // zamkniecie okna spowoduje zakonczenie programu frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // nowy napis
        JLabel label = new JLabel("Hello World");
        // napis jest dodawany do zawartosci okna
        frame.getContentPane().add(label);
        // dopasowanie rozmiarow okna do umieszczonych w nim komponentow frame.pack();
        // wyswietlenie okna
        frame.setVisible(true);
    }
    public static void main(String[] args) {
            // stworzenie nowego watku, w ktorym zostanie 'uruchomione' okno
            // SwingUtilities.invokeLater(new Runnable() { public void run() {
            // createAndShowGUI(); }
            // }); 
            createAndShowGUI();
    }
}