import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.UIManager.*;

public class Program {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("not found.");
        }

        JFrame frame = new JFrame("BrowserVault");
        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.setSize(360, 160);

        Border border = BorderFactory.createEmptyBorder(15, 15, 10, 15);
        panel.setBorder(border);

        JLabel welcomeLabel = new JLabel("Please paste the provided link in the text field below, then press GO.");

        JTextField linkField = new JTextField();

        JButton goButton = new JButton("GO");

        AbstractAction onPress = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String link = linkField.getText();
                if (!link.startsWith("http")) {
                    link = "http://" + link;
                }
                BrowserVault.browser(link);
            }
        };

        goButton.addActionListener(onPress);
        linkField.addActionListener(onPress);

        panel.add(welcomeLabel);
        panel.add(linkField);
        panel.add(goButton);

        frame.add(panel);
        frame.setSize(500, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
