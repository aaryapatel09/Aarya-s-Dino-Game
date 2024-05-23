

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class iPhoneGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton homeButton;
    private JButton appButton;
    private boolean isHorizontal = false;
    private Main m;
    private Component dino;

    public iPhoneGUI() {
        setTitle("iPhone Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 750);
        setResizable(false);
        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        // Initialize home button
        homeButton = new JButton();
        homeButton.setBounds(175, 625, 30, 30); // button position 
        homeButton.addActionListener(this); // Add action listener
        add(homeButton); // Add button to the frame
        homeButton.setBackground(Color.WHITE);

        // Initialize app button
        appButton = new JButton();
        appButton.setBounds(83, 167, 30, 30);
        appButton.addActionListener(this); // Add action listener
        add(appButton); // Add button to the frame
        appButton.setBackground(Color.PINK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set up common colors
        final Color beige = new Color(245, 245, 220);

        // Clear the screen
        g2d.setColor(getContentPane().getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());

        if (isHorizontal) {
            // Rotate the entire graphics context
            g2d.rotate(Math.toRadians(270), getWidth() / 2, getHeight() / 2);

            // Adjust the drawing coordinates
            g2d.translate((getWidth() - getHeight()) / 2, (getHeight() - getWidth()) / 2);
        }

        // Draw iPhone frame outline
        g2d.setColor(Color.BLACK);
        g2d.fillRoundRect(25, 80, 340, 640, 50, 50);

        // Draw iPhone internal frame outline
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(45, 100, 300, 600, 50, 50);

        // Draw for home button
        g2d.setColor(Color.BLACK);
        g2d.fillRoundRect(172, 645, 50, 50, 30, 30);

        // Draw top and bottom line
        g2d.setColor(Color.BLACK);
        g2d.drawLine(350, 640, 45, 640); // Top line
        g2d.drawLine(350, 150, 45, 150); // Bottom line
        g2d.fillRoundRect(183, 115, 25, 25, 30, 30); // Camera

        // Wallpaper
        g2d.setColor(beige);
        g2d.fillRoundRect(45, 151, 300, 489, 10, 50);

        if (!isHorizontal) {
            // Draw app
            g2d.setColor(Color.PINK);
            g2d.fillRoundRect(75, 180, 60, 60, 30, 30);
        }

        // Reset rotation if applied
        if (isHorizontal) {
            g2d.rotate(-Math.toRadians(90), getWidth() / 2, getHeight() / 2);
            g2d.translate(-(getWidth() - getHeight()) / 2, -(getHeight() - getWidth()) / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == appButton) {
            isHorizontal = true;
            setSize(750, 400);
            // Adjust button positions for horizontal mode
            homeButton.setBounds(648, 160, 30, 30); // Centered in the home button rectangle in horizontal mode
            appButton.setVisible(false); // Hide the app button
            
            revalidate();
            repaint();
        }
        if (e.getSource() == homeButton) {
            isHorizontal = false;
            setSize(400, 750);
            // Adjust button positions for vertical mode
            appButton.setBounds(83, 167, 30, 30);
            appButton.setVisible(true); // Show the app button
            homeButton.setBounds(175, 625, 30, 30); // Centered in the home button rectangle in vertical mode
            revalidate();
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new iPhoneGUI().setVisible(true);
        });
    }
}

