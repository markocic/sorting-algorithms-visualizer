package markocic.sorting_algorithms_visualizer.algorithms;

import lombok.Getter;
import lombok.Setter;

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
}
