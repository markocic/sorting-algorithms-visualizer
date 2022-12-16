package markocic.sorting_algorithms_visualizer.view;

import lombok.Getter;
import lombok.Setter;
import markocic.sorting_algorithms_visualizer.algorithms.BubbleSort;
import markocic.sorting_algorithms_visualizer.algorithms.InsertionSort;
import markocic.sorting_algorithms_visualizer.algorithms.SelectionSort;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@Setter
public class MainMenu extends JPanel {

    private JSpinner msDelay;
    private JButton startSort;
    private JButton bubbleSort;
    private JButton selectionSort;
    private JButton insertionSort;
    private JButton shuffle;
    public MainMenu() {
        setBackground(Color.DARK_GRAY);
        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);

        msDelay = new JSpinner(new SpinnerNumberModel(10, 0, 10000, 1));
        startSort = new JButton("Sort");
        bubbleSort = new JButton("Bubble sort");
        selectionSort = new JButton("Selection sort");
        insertionSort = new JButton("Insertion sort");
        shuffle = new JButton("Shuffle");

        add(msDelay);
        add(startSort);
        add(bubbleSort);
        add(selectionSort);
        add(insertionSort);
        add(shuffle);

        msDelay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MainFrame.getInstance().getSortingPanel().setMillisecondsDelay((Integer) msDelay.getValue());
            }
        });

        startSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() {
                        MainFrame.getInstance().getCurrentSort().runSort();
                        MainFrame.getInstance().getSortingPanel().checkSorted();
                        return null;
                    }
                };

                swingWorker.execute();
            }
        });

        bubbleSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().setCurrentSort(new BubbleSort());
            }
        });

        selectionSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().setCurrentSort(new SelectionSort());
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
