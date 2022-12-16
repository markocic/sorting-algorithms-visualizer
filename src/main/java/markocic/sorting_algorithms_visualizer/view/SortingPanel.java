package markocic.sorting_algorithms_visualizer.view;

import com.sun.tools.javac.Main;
import lombok.Getter;
import lombok.Setter;
import markocic.sorting_algorithms_visualizer.algorithms.BubbleSort;
import markocic.sorting_algorithms_visualizer.algorithms.Sort;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@Getter
@Setter
public class SortingPanel extends JPanel {

    private ArrayList<Integer> array;
    private ArrayList<Color> colors;
    private final int barWidth = 4;
    private final int barHeight = 2;
    private int millisecondsDelay = 10;
    private int numChanges = 0;
    private Sort currentSort = new BubbleSort();

    private final Random random = new Random();

    public SortingPanel() {
        setBackground(Color.DARK_GRAY);
        initializeArray();
        initializeColors();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(barWidth));

        int x = barWidth / 2;
        int y = getHeight();
        for (int i = 0; i < array.size(); i++) {
            g2.setPaint(colors.get(i));
            g2.drawLine(x, y, x, y - barHeight * array.get(i));
            x += barWidth;
        }

        drawInfoPanel(g2);
    }

    private void drawInfoPanel(Graphics2D g2) {
        // this is drawing a "shadow" of the rectangle
        g2.setColor(new Color(10, 10, 10, 100));
        g2.fill(new Rectangle2D.Double(25, 25, 300, 100));

        Rectangle2D rectangle2D = new Rectangle2D.Double(20, 20, 300, 100);
        g2.setColor(new Color(51, 51, 51));
        g2.fill(rectangle2D);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        g2.drawString("Sorting algorithm: " + currentSort.getName(), 35, 40);
        g2.drawString("Changes to array: " + numChanges, 35, 60);
        g2.drawString("Current delay: " + millisecondsDelay, 35, 80);
    }

    public void initializeArray() {
        array = new ArrayList<>();
        for (int i = 1; i <= MainFrame.getInstance().getWIDTH() / barWidth; i++) {
            array.add(i);
        }
        repaint();
        currentSort.setArraySize(array.size());
    }

    public void initializeColors() {
        colors = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            colors.add(Color.WHITE);
        }
    }

    public void swapNumbers(int i, int j, boolean change)  {
        colors.set(i, Color.GREEN);
        colors.set(j, Color.RED);

        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);

        if (change) numChanges++;

        showUpdate();
    }
    public void swapColors(int i, int j)  {
        Color temp = colors.get(i);
        colors.set(i, colors.get(j));
        colors.set(j, temp);

        showUpdate();
    }

    public void shuffle() {

        for (int i = 0; i < array.size() - 1; i++) {
            int swapIndex = random.nextInt(array.size() - 1);
            swapNumbers(i, swapIndex, false);
            resetColors();
        }
        updateUI();
    }

    public void resetColors() {
        Collections.fill(colors, Color.WHITE);
    }

    /*
    * doesn't actually do anything, just for the satisfying ending
     */
    public void checkSorted() {
        for (int i = 0; i < array.size(); i++) {
            System.out.println("here");
            colors.set(i, Color.RED);
            showUpdate();
            resetColors();
        }

        showUpdate();
    }

    public void showUpdate() {
        updateUI();
        try {
            Thread.sleep(millisecondsDelay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public Sort getCurrentSort() {
        return currentSort;
    }

    public void setCurrentSort(Sort currentSort) {
        this.currentSort = currentSort;
        numChanges = 0;
        repaint();
    }

    public void setMillisecondsDelay(int millisecondsDelay) {
        this.millisecondsDelay = millisecondsDelay;
        repaint();
    }
}
