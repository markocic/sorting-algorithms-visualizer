package markocic.sorting_algorithms_visualizer.algorithms;

import markocic.sorting_algorithms_visualizer.view.MainFrame;
import markocic.sorting_algorithms_visualizer.view.SortingPanel;

import java.awt.*;
import java.util.ArrayList;

public class InsertionSort extends Sort {

    @Override
    public String getName() {
        return "Insertion sort";
    }

    @Override
    public void runSort() {
        SortingPanel sortingPanel = MainFrame.getInstance().getSortingPanel();
        ArrayList<Integer> array = sortingPanel.getArray();

        for (int i = 1; i < arraySize; i++) {
            int curr = array.get(i);
            int j = i - 1;

            sortingPanel.resetColors();
            sortingPanel.highlightNumber(i, Color.GREEN);
            sortingPanel.highlightNumber(i - 1, Color.RED);

            while (j >= 0 && array.get(j) > curr) {

                sortingPanel.resetColors();
                sortingPanel.highlightNumber(j + 1, Color.GREEN);
                sortingPanel.highlightNumber(j, Color.RED);

                array.set(j + 1, array.get(j));
                incChanges();
                j--;
            }

            array.set(j + 1, curr);
            incChanges();
        }
    }
}
