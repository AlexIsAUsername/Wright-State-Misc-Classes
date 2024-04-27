import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;


class GettingWarmer {
        public GettingWarmer() {
                //makes frame and panels
                JFrame frame = new JFrame("Temp changer");
                JPanel root = new JPanel();
                JPanel innerpanel = new JPanel();

                //setup panels
                root.setLayout(new BorderLayout());
                innerpanel.setLayout(new GridLayout(2, 2));
                innerpanel.setPreferredSize(new Dimension(0, 70));//sets the size for the inner panel so it wont be too small
                JPanel buttonPanel = new JPanel();

                //makes labels, textfields, and buttons
                JLabel farenheit = new JLabel("Farenheit");
                JLabel celsius = new JLabel("Celsius");
                JTextField enterFarenheit = new JTextField("");
                JTextField enterCelsius = new JTextField("");
                JButton convert = new JButton("Convert");

                //adds functionality to the button
                convert.addActionListener(e -> {
                    double calculate;
                    calculate = ((Double.parseDouble(enterFarenheit.getText())) - 32) * 5 / 9;
                    enterCelsius.setText(((Double) (calculate)).toString());
                });

                //adds the buttons, etc to the panels
                root.add(innerpanel, BorderLayout.NORTH);
                root.add(buttonPanel, BorderLayout.WEST);
                innerpanel.add(farenheit);
                innerpanel.add(celsius);
                innerpanel.add(enterFarenheit);
                innerpanel.add(enterCelsius);
                buttonPanel.add(convert);
                
                //sets details on frame
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(root);
                frame.setSize(300, 150);
                frame.setVisible(true);
        }
        public static void main(String[] args) {
                new GettingWarmer();
        }
}
