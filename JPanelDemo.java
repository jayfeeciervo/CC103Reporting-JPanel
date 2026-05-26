package JPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class JPanelDemo extends JFrame{

    public JPanelDemo() throws HeadlessException {
        this.getContentPane().add(new JButton("Stringggg"));
    }

    public static void main(String[] args) {

        // Run GUI safely on Event Dispatch Thread (best practice for Swing)
        SwingUtilities.invokeLater(() -> {

            try {
                JPanel(); // Call method that builds the interface

            } catch (Exception e) {
                // 🔴 GENERAL EXCEPTION HANDLER
                // This catches ANY unexpected error that was not specifically handled
                System.err.println("Unexpected error occurred while creating GUI.");
               

                JOptionPane.showMessageDialog(null,
                        "Something went wrong while loading the application.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private static void JPanel() {//test 

        // Create main frame (window)
        JFrame frame = new JFrame("JPanel Demo");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel (container inside frame)
        JPanel panel = new JPanel();

        // 🔴 EXCEPTION SAFETY CHECK (NullPointerException prevention)
        // This ensures panel is properly created before using it
        if (panel == null) {
            throw new NullPointerException("Panel was not initialized properly!");
        }

        panel.setBackground(Color.ORANGE);

        // Add border so we can visually see the panel
        panel.setBorder(new LineBorder(Color.BLACK, 5));

        // Layout manager controls arrangement of components
        panel.setLayout(new GridLayout(3, 5, 10, 10));//GridLayout(rows, columns, horizontalGap, verticalGap)

        // Add components to panel
        panel.add(new JLabel("Name:"));
        panel.add(new JTextField());
        

        panel.add(new JLabel("Age:"));
        panel.add(new JTextField());

        panel.add(new JButton("Submit"));
        panel.add(new JButton("Clear"));
        
   
       
        // Add panel to frame
        frame.add(panel);

        // Display frame
        frame.setVisible(true);
    }
}