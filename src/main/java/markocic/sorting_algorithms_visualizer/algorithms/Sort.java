package markocic.sorting_algorithms_visualizer.algorithms;

import lombok.Getter;
import lombok.Setter;
import markocic.sorting_algorithms_visualizer.view.MainFrame;

@Getter
@Setter
public abstract class Sort {
    public static int arraySize = 0;
    public void runSort() {
        System.out.println("default sort");
    }

    public void setArraySize(int size) {
        arraySize = size;
    }

    public String getName() { return null; }

    /*
     * this will increment numChanges variable from SortingPanel class
     */
    public void incChanges() {
        MainFrame.getInstance().getSortingPanel().setNumChanges(MainFrame.getInstance().getSortingPanel().getNumChanges() + 1);
    }
}
