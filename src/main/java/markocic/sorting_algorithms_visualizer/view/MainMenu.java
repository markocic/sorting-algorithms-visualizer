package markocic.sorting_algorithms_visualizer.view;

import lombok.Getter;
import lombok.Setter;
import markocic.sorting_algorithms_visualizer.algorithms.BubbleSort;
import markocic.sorting_algorithms_visualizer.algorithms.InsertionSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class MainMenu extends JPanel {

    private JButton startSort;
    private JButton bubbleSort;
    private JButton insertionSort;
    private JButton reset;
    public MainMenu() {
        setBackground(Color.DARK_GRAY);
        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        startSort = new JButton("Sort");
        bubbleSort = new JButton("Bubble sort");
        insertionSort = new JButton("Insertion sort");
        reset = new JButton("Reset");

        add(startSort);
        add(bubbleSort);
        add(insertionSort);
        add(reset);

        startSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getCurrentSort().runSort();
            }
        });

        bubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().setCurrentSort(new BubbleSort());
            }
        });

        insertionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().setCurrentSort(new InsertionSort());
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getCurrentSort().shuffle();
            }
        });
    }
}
