package markocic.sorting_algorithms_visualizer.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class SortingPanel extends JPanel {

    private ArrayList<Integer> array;
    private ArrayList<Color> colors;
    private final int barWidth = 4;
    private final int barHeight = 2;
    private int millisecondsDelay = 10;
    private int i;
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
        int y = MainFrame.getInstance().getHEIGHT() - MainFrame.getInstance().getMenu().getHeight() - 34;
        System.out.println(y);
        for (int i = 0; i < array.size(); i++) {
            g2.setPaint(colors.get(i));
            g2.drawLine(x, y, x, y - barHeight * array.get(i));
            x += barWidth;
        }
    }

    public void initializeArray() {
        array = new ArrayList<>();
        for (int i = 1; i <= MainFrame.getInstance().getWIDTH() / barWidth; i++) {
            array.add(i);
        }
        repaint();
    }

    public void initializeColors() {
        colors = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            colors.add(Color.WHITE);
        }
    }

    public void swapNumbers(int i, int j)  {
        colors.set(i, Color.GREEN);
        colors.set(j, Color.RED);

        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);

        showUpdate(millisecondsDelay);
    }
    public void swapColors(int i, int j)  {
        Color temp = colors.get(i);
        colors.set(i, colors.get(j));
        colors.set(j, temp);

        showUpdate(millisecondsDelay);
    }

    public void shuffle() {

        for (int i = 0; i < array.size() - 1; i++) {
            int swapIndex = random.nextInt(array.size() - 1);
            swapNumbers(i, swapIndex);
            resetColors();
        }
        
    }

    private void resetColors() {
        for (int i = 0; i < colors.size(); i++) {
            colors.set(i, Color.WHITE);
        }
    }

    public void showUpdate(int delay) {
        updateUI();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
