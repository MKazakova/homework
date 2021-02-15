package homework4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class ChatGui extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JPanel chatPanel = new JPanel();
    private JScrollPane js = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JTextField textInput = new JTextField();
    private JLabel textInputLabel = new JLabel("Your message :");
    private final JButton sendButton = new JButton("Send");
    private final ActionListener listener = event -> {
        sendMessage(textInput.getText()+"\n");
        textInput.setText("");
    };

    public ChatGui(){
        this.setTitle("Chat");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new FlowLayout());
        textArea.setEditable(false);
        chatPanel.setBackground(Color.white);
        chatPanel.setPreferredSize(new Dimension(490, 490));
        js.setPreferredSize(new Dimension(450, 350));
        chatPanel.add(js);
        textInput.setPreferredSize(new Dimension(150, 25));
        chatPanel.add(textInputLabel);
        chatPanel.add(textInput);

        textInput.addActionListener(listener);
        sendButton.addActionListener(listener);
        chatPanel.add(sendButton);
        this.add(chatPanel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatGui();
            }
        });
    }

    public void sendMessage(String str) {
        textArea.append(str);
    }
}
