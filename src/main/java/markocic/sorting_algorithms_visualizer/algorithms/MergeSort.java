package markocic.sorting_algorithms_visualizer.algorithms;

import markocic.sorting_algorithms_visualizer.view.MainFrame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MergeSort extends Sort {

    @Override
    public String getName() {
        return "Merge sort";
    }

    @Override
    public void runSort() {
        ArrayList<Integer> result = sort(MainFrame.getInstance().getSortingPanel().getArray());
        MainFrame.getInstance().getSortingPanel().setArray(result);
        MainFrame.getInstance().getSortingPanel().repaint();
    }

    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        if (array.size() == 1) return array;

        ArrayList<Integer> arrayOne = new ArrayList<>(array.subList(0, array.size() / 2));
        ArrayList<Integer> arrayTwo = new ArrayList<>(array.subList(array.size() / 2, array.size()));

        arrayOne = sort(arrayOne);
        arrayTwo = sort(arrayTwo);

        return merge(arrayOne, arrayTwo);

    }

    public ArrayList<Integer> merge(List<Integer> arrayOne, List<Integer> arrayTwo) {
        ArrayList<Integer> result = new ArrayList<>();

        while (!arrayOne.isEmpty() && !arrayTwo.isEmpty()) {
            if (arrayOne.get(0) > arrayTwo.get(0)) {
                result.add(arrayTwo.get(0));
                arrayTwo.remove(0);
            } else {
                result.add(arrayOne.get(0));
                arrayOne.remove(0);
            }
        }

        if (!arrayOne.isEmpty()) {
            result.addAll(arrayOne);
        } else {
            result.addAll(arrayTwo);
        }

        return result;
    }
 }
