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
    private JButton shuffle;
    public MainMenu() {
        setBackground(Color.DARK_GRAY);
        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        startSort = new JButton("Sort");
        bubbleSort = new JButton("Bubble sort");
        insertionSort = new JButton("Insertion sort");
        shuffle = new JButton("Reset");

        add(startSort);
        add(bubbleSort);
        add(insertionSort);
        add(shuffle);

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

        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<>() {

                    @Override
                    protected Void doInBackground() {
                        MainFrame.getInstance().getSortingPanel().shuffle();

                        return null;
                    }
                };

                worker.execute();
            }
        });
    }
}
