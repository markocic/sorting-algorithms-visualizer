package markocic.sorting_algorithms_visualizer.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static MainFrame instance = null;

    private MainFrame() {}

    private void initialize() {
        setTitle("Sorting Algorithms Visualizer");
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblText = new JLabel("Test", SwingConstants.CENTER);

        getContentPane().add(lblText);

        pack();
        setVisible(true);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }


}
