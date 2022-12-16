package markocic.sorting_algorithms_visualizer.algorithms;

import markocic.sorting_algorithms_visualizer.view.MainFrame;
import markocic.sorting_algorithms_visualizer.view.SortingPanel;

import java.util.ArrayList;

public class BubbleSort extends Sort {
    @Override
    public void runSort() {
        SortingPanel sort = MainFrame.getInstance().getSortingPanel();
        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                ArrayList<Integer> array = sort.getArray();
                if (array.get(j) > array.get(j + 1)) {
                    sort.swapNumbers(j, j+1);
                    sort.resetColors();

                }
            }
        }

    }
}
