package markocic.sorting_algorithms_visualizer.view;

import lombok.Getter;
import lombok.Setter;
import markocic.sorting_algorithms_visualizer.algorithms.BubbleSort;
import markocic.sorting_algorithms_visualizer.algorithms.Sort;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private Sort currentSort = new BubbleSort();

    private MainFrame() {}

    private void initialize() {
        setTitle("Sorting Algorithms Visualizer");
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setForeground(Color.WHITE);
        setMinimumSize(new Dimension(1280, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());

        MainMenu menu = new MainMenu();
        SortingPanel sortingPanel = new SortingPanel();

        getContentPane().add(menu, BorderLayout.NORTH);
        getContentPane().add(sortingPanel, BorderLayout.CENTER);

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
