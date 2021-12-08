import java.awt.Dimension;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Swing {

    static JTextArea text;

    static ActionListener loadActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                loadText(fc.getSelectedFile());
            }
        }
    };

    static ActionListener saveActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                saveText(fc.getSelectedFile());
            }
        }
    };

    public static void loadText(File file){
        try {
            BufferedReader br;
            String s;
            br = new BufferedReader(new FileReader(file));
            text.setText("");
            while((s = br.readLine()) != null){
                text.append(s + "\n");
            }
            br.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void saveText(File file){
        try {
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(file));
            String s = text.getText();
            bw.write(s, 0, s.length());
            bw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static JPanel createPanel(){
        JPanel p = new JPanel();

        text = new JTextArea();
        JScrollPane sp = new JScrollPane(text);
        sp.setPreferredSize(new Dimension(600, 400));
        p.add(sp);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton b = new JButton("load");
        b.addActionListener(loadActionListener);

        buttonPanel.add(b);

        b = new JButton("save");
        b.addActionListener(saveActionListener);

        buttonPanel.add(b);
        p.add(buttonPanel);
        return p;
    }

    public static JFrame createFrame() {
        JFrame f = new JFrame("My Editor");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(createPanel());
        JMenuBar mb = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem mi = new JMenuItem("load");
        mi.addActionListener(loadActionListener);
        mFile.add(mi);

        mi = new JMenuItem("save");
        mi.addActionListener(saveActionListener);
        mFile.add(mi);

        mb.add(mFile);


        f.setJMenuBar(mb);
        f.pack();
        f.setVisible(true);

        return f;
    }

    public static void main(String[] args) {
        JFrame f = createFrame();
    }
    
}
