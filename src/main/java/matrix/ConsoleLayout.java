package matrix;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ConsoleLayout extends JPanel {

    private JTextArea textArea;

    public ConsoleLayout() {
        textArea = new JTextArea();
        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    public void appendText(String text) {
        textArea.append(text);
    }
}
