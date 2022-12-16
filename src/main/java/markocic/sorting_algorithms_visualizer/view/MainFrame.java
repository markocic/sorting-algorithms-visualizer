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
    private final int WIDTH = 1280;
    private final int HEIGHT = 720;
    private MainMenu menu;
    private SortingPanel sortingPanel;
    private Sort currentSort = new BubbleSort();

    private MainFrame() {}

    private void initialize() {
        setTitle("Sorting Algorithms Visualizer");
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setForeground(Color.WHITE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());

        menu = new MainMenu();
        sortingPanel = new SortingPanel();

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

    public Sort getCurrentSort() {
        return currentSort;
    }

    public void setCurrentSort(Sort currentSort) {
        this.currentSort = currentSort;
        sortingPanel.repaint();
    }
}
