import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class gameStart {
    // difficulty adjustment values
    private int difficultyTimer;
    private int difficultySize;
    private int numberOfSpaces;

    // RNG for where to click, score and health tracking (had to be pulled out because of the timer)
    private static Random rng = new Random();
    private int toBeClickedrng;
    private int score = 0;
    private int health = 3;

    // Initial image generation, all pulled out for readability (cookieMonster had to be pulled out because of the timer)
    private ImageIcon hole = new ImageIcon("a.png");
    private ImageIcon cookieMonster = new ImageIcon("b.png");
    private ImageIcon cookie = new ImageIcon("c.png");
    private ImageIcon eatenCookie = new ImageIcon("d.png");

    // Instructions on how to play the game, difficulty selection
    public gameStart() {
        JFrame frame = new JFrame("Welcome to Whack-a-Cookie-Monster");
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.PAGE_AXIS));

        // Instructions on how to play Whack-a-Cookie-Monster
        JLabel instructionLabel = new JLabel("<html>"
                + "Click on the vile Cookie Monster to protect your cookies from his grubby little hands!<br/>"
                + "If you don't, he will take exactly one bite out of each of your three cookies, claiming them as his own!<br/>"
                + "Giving up while Cookie Monster is around will mean you have forfeited both your cookies and points to him!<br/><br/>"
                + "Please select a difficulty for Whack-a-Cookie-Monster:<br/>" + "<html>");// https://stackoverflow.com/questions/2420742/make-a-jlabel-wrap-its-text-by-setting-a-max-width , https://stackoverflow.com/questions/1090098/newline-in-jlabel
        instructionLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        // https://docs.oracle.com/javase/tutorial/uiswing/examples/components/RadioButtonDemoProject/src/components/RadioButtonDemo.java
        // Difficulty selection
        JRadioButton easyButton = new JRadioButton("easy: 1x1 grid");
        easyButton.setMnemonic(KeyEvent.VK_E);
        easyButton.setActionCommand("easy: 1x1 grid");
        JRadioButton mediumButton = new JRadioButton("medium: 3x3 grid");
        mediumButton.setMnemonic(KeyEvent.VK_M);
        mediumButton.setActionCommand("medium: 3x3 grid");
        JRadioButton hardButton = new JRadioButton("hard: 5x5 grid");
        hardButton.setMnemonic(KeyEvent.VK_H);
        hardButton.setActionCommand("hard: 5x5 grid");

        ButtonGroup group = new ButtonGroup();
        group.add(easyButton);
        group.add(mediumButton);
        group.add(hardButton);

        easyButton.addActionListener(e -> {
            difficultyTimer = 2000;
            difficultySize = 1;
        });
        mediumButton.addActionListener(e -> {
            difficultyTimer = 1500;
            difficultySize = 3;
        });
        hardButton.addActionListener(e -> {
            difficultyTimer = 1000;
            difficultySize = 5;
        });

        JPanel difficultyPanel = new JPanel(new GridLayout(0, 1));
        difficultyPanel.add(easyButton);
        difficultyPanel.add(mediumButton);
        difficultyPanel.add(hardButton);
        // until here

        JButton continueButton = new JButton("Continue");
        continueButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        continueButton.addActionListener(e -> {
            numberOfSpaces = difficultySize * difficultySize;
            whackACookieMonster(frame);
        });

        root.add(instructionLabel);
        root.add(difficultyPanel);
        root.add(continueButton);
        frame.add(root);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// https://stackoverflow.com/questions/1944446/close-one-jframe-without-closing-another
        frame.getContentPane().add(root);
        frame.setSize(700, 250);
        frame.setVisible(true);
    }

    // The body of the game
    public void whackACookieMonster(Frame gameStart) {
        JFrame frame = new JFrame("Whack-A-CookieMonster test");
        JPanel root = new JPanel();
        JPanel whackJPanel = new JPanel();
        JPanel healthPanel = new JPanel();

        root.setLayout(new BoxLayout(root, BoxLayout.PAGE_AXIS));
        whackJPanel.setLayout(new GridLayout(difficultySize, difficultySize, 10, 10));
        healthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Score and health label generation and font setting
        JLabel scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(scoreLabel.getFont().deriveFont((float) 20));
        JLabel healthLabel = new JLabel("Health: ");
        healthLabel.setFont(scoreLabel.getFont());

        // Lecture recording 15
        // Makes the buttons for the game
        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < numberOfSpaces; i++) {
            JButton whackJButton = new JButton();
            whackJButton.setSize(new Dimension(500 / difficultySize, 500 / difficultySize));
            hole = resizeIcon(hole, whackJButton.getWidth(), whackJButton.getHeight());
            cookieMonster = resizeIcon(cookieMonster, whackJButton.getWidth(), whackJButton.getHeight());
            whackJButton.setIcon(hole);
            // until here
            // Logic control for the buttons and score updating
            whackJButton.addActionListener(e -> {
                if (whackJButton.getIcon() == cookieMonster) {
                    whackJButton.setIcon(hole);
                    score += 5;
                } else {
                    score -= 10;
                }
                scoreLabel.setText("Score: " + score);
            });
            buttons.add(whackJButton);
            whackJPanel.add(buttons.get(i));
        }

        // Makes the health (cookies) labels and puts them into its panel
        healthPanel.add(healthLabel);
        ArrayList<JLabel> healthArray = new ArrayList<>();
        for (int i = 0; i < health; i++) {
            JLabel cookieLabel = new JLabel();
            cookieLabel.setSize(new Dimension(100, 100));
            cookie = resizeIcon(cookie, cookieLabel.getWidth(), cookieLabel.getHeight());
            eatenCookie = resizeIcon(eatenCookie, cookieLabel.getWidth(), cookieLabel.getHeight());
            cookieLabel.setIcon(cookie);
            healthArray.add(cookieLabel);
            healthPanel.add(healthArray.get(i));
        }

        // Timer to reset the board if necessary, make the cookie monster appear
        Timer clickMe = new Timer(difficultyTimer, e -> {
            for (int i = 0; i < numberOfSpaces; i++) {
                if (buttons.get(i).getIcon() == cookieMonster) {
                    buttons.get(i).setIcon(hole);
                    score -= 5;
                    scoreLabel.setText("Score: " + score);
                    health -= 1;
                    healthArray.get(health).setIcon(eatenCookie);
                }
            }
            toBeClickedrng = rng.nextInt(numberOfSpaces);
            buttons.get(toBeClickedrng).setIcon(cookieMonster);
            if (health == 0) {
                gameOver(frame);
            }
        });
        clickMe.start();

        whackJPanel.setPreferredSize(new Dimension(500, 500));
        healthPanel.setPreferredSize(new Dimension(500, 200));
        root.add(scoreLabel);
        root.add(whackJPanel);
        root.add(healthPanel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(root);
        frame.setSize(500, 900);
        frame.setVisible(true);
        gameStart.dispatchEvent(new WindowEvent(gameStart, WindowEvent.WINDOW_CLOSING));// https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
    }

    // Game over screen
    private void gameOver(Frame clicker) {
        JFrame frame = new JFrame("GAME OVER");
        JPanel root = new JPanel();

        JLabel finalScoreLabel = new JLabel("Final Score: " + score);
        finalScoreLabel.setFont(finalScoreLabel.getFont().deriveFont((float) 50));

        root.add(finalScoreLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(root);
        frame.setSize(500, 150);
        frame.setVisible(true);
        clicker.dispatchEvent(new WindowEvent(clicker, WindowEvent.WINDOW_CLOSING));
    }

    // https://stackoverflow.com/questions/36957450/fit-size-of-an-imageicon-to-a-jbutton
    // Resizes images to fit
    private static ImageIcon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    // until here

    public static void main(String[] args) {
        new gameStart();
    }
}