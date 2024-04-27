import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class GettingBigger extends JPanel implements ChangeListener{
    private float fontSize = 15;
    private JTextField textField = new JTextField("Type here...");
    private Font textFieldFont = textField.getFont();
    public GettingBigger(){
        JFrame frame = new JFrame("Text Decorator");
        JPanel root = new JPanel();

        //https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
        root.setLayout(new BoxLayout(root, BoxLayout.PAGE_AXIS)); 
        //until here
        
        root.add(textField);

        //https://docs.oracle.com/javase/tutorial/uiswing/components/slider.html
        JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 15); 
        sizeSlider.setMajorTickSpacing(25);
        sizeSlider.setMinorTickSpacing(5);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        //until here

        // got help from TA
        //adds functionality to the slider
        sizeSlider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
            JSlider sliderValue = (JSlider) e.getSource();
            fontSize = (float) sliderValue.getValue();
            textField.setFont(textFieldFont.deriveFont(fontSize)); //https://docs.oracle.com/javase/7/docs/api/java/awt/Font.html
    
        }});
        //until here

        root.add(sizeSlider);

        frame.getContentPane().add(root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args){
        new GettingBigger();
    }

    
}