package markocic.sorting_algorithms_visualizer.algorithms;

import markocic.sorting_algorithms_visualizer.view.MainFrame;

import java.util.ArrayList;

public class SelectionSort extends Sort {
    @Override
    public String getName() {
        return "Selection sort";
    }

    @Override
    public void runSort() {
        for (int i = 0; i < arraySize - 1; i++) {
            int minIndex = i;
            ArrayList<Integer> array = MainFrame.getInstance().getSortingPanel().getArray();
            for (int j = i + 1; j < arraySize; j++) {
                if (array.get(minIndex) > array.get(j)) {
                    minIndex = j;
                }
            }
            MainFrame.getInstance().getSortingPanel().swapNumbers(i, minIndex, true);
            MainFrame.getInstance().getSortingPanel().resetColors();
        }
    }
}
