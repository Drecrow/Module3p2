package Module3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Userinterface extends JFrame implements ActionListener {
    private JTextArea outputTextArea;
    private JMenuBar menuBar;
    private JMenuItem printDateTimeItem, saveToTextFileItem, changeBackgroundColorItem, exitItem;

    public Userinterface() {
        setTitle("Menu Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        printDateTimeItem = new JMenuItem("Print Date/Time");
        saveToTextFileItem = new JMenuItem("Save to Text File");
        changeBackgroundColorItem = new JMenuItem("Change Background Color");
        exitItem = new JMenuItem("Exit");
        printDateTimeItem.addActionListener(this);
        saveToTextFileItem.addActionListener(this);
        changeBackgroundColorItem.addActionListener(this);
        exitItem.addActionListener(this);
        menu.add(printDateTimeItem);
        menu.add(saveToTextFileItem);
        menu.add(changeBackgroundColorItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == printDateTimeItem) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = dateFormat.format(new Date());
            outputTextArea.append(dateTime + "\n");
        } else if (e.getSource() == saveToTextFileItem) {
            try {
                FileWriter writer = new FileWriter("C:\\Users\\jeanc\\Downloads\\log.txt", true);
                writer.write(outputTextArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(this, "Text saved to log.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == changeBackgroundColorItem) {
            Random rand = new Random();
            
            float hue = rand.nextFloat() * 0.1667f + 0.25f;
            Color color = Color.getHSBColor(hue, 1.0f, 1.0f); 
            getContentPane().setBackground(color);
        } else if (e.getSource() == exitItem) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Userinterface();
    }
}
 