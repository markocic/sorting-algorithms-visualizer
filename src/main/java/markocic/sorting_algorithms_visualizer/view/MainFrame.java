package markocic.sorting_algorithms_visualizer.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private JLabel lblText;

    private MainFrame() {}

    private void initialize() {
        setTitle("Sorting Algorithms Visualizer");
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setForeground(Color.WHITE);
        setMinimumSize(new Dimension(1280, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblText = new JLabel("Test", SwingConstants.CENTER);
        lblText.setForeground(Color.WHITE);
        getContentPane().add(lblText, SwingConstants.CENTER);

        pack();
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }

}
