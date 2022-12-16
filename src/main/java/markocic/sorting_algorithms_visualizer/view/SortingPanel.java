package markocic.sorting_algorithms_visualizer.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

@Getter
@Setter
public class SortingPanel extends JPanel {

    private ArrayList<Integer> array;
    private final int barWidth = 4;
    private final int barHeight = 2;

    private int i;
    private final Random random = new Random();

    public SortingPanel() {
        setBackground(Color.DARK_GRAY);
        initializeArray();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.WHITE);
        g2.setStroke(new BasicStroke(barWidth));

        int x = barWidth / 2;
        int y = MainFrame.getInstance().getHEIGHT() - MainFrame.getInstance().getMenu().getHeight() - 34;
        System.out.println(y);
        for (Integer num : array) {
            g2.drawLine(x, y, x, y - barHeight * num);
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

    public void swap(int i, int j) throws InterruptedException {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);


    }

    public void shuffle() {


        new TimerFor(10, 0, array.size() - 1, i -> {
            try {
                swap(i, random.nextInt(array.size() - 1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            updateUI();
            return false;
        });

    }

    public class TimerFor implements ActionListener {
        private final Timer t;
        private final int upper;
        private final Function<Integer, Boolean> body;
        private int i;

        public TimerFor(int delay, int lower, int upper, Function<Integer, Boolean> body) {
            i = lower;
            this.upper = upper;
            this.body = body;
            t = new Timer(delay, this);
            t.setRepeats(true);
            t.start();
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (i >= upper || body.apply(i)) {
                t.stop();
                return;
            }
            i++;
        }
    }
}
