package markocic.sorting_algorithms_visualizer.view;

import lombok.Getter;
import lombok.Setter;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

@Getter
@Setter
public class MainMenu extends JFrame {

    private String selected;
    private ButtonGroup sort;
    private JRadioButton bubble;
    private JRadioButton quick;
    private JRadioButton merge;
    private JRadioButton selection;
    private JRadioButton counting;
    private JRadioButton placeholder;
    private JButton start;

    public MainMenu() {
        setTitle("Main Menu");
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setForeground(Color.WHITE);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        sort = new ButtonGroup();
        bubble = new JRadioButton("Bubble sort");
        quick = new JRadioButton("Quick sort");
        merge = new JRadioButton("Merge sort");
        selection = new JRadioButton("Selection sort");
        counting = new JRadioButton("Counting sort");
        placeholder = new JRadioButton("Placeholder");
        start = new JButton("Start sorting");

        sort.add(bubble);
        sort.add(quick);
        sort.add(merge);
        sort.add(selection);
        sort.add(counting);
        sort.add(placeholder);

        setButtonBackground();

        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        contentPane.add(bubble, "cell 3 2");
        contentPane.add(merge, "cell 5 2");
        contentPane.add(selection, "cell 3 3");
        contentPane.add(quick, "cell 5 3");
        contentPane.add(counting, "cell 3 4");
        contentPane.add(placeholder, "cell 5 4");
        contentPane.add(start, "cell 3 6 3 1");
        pack();
        setLocationRelativeTo(getOwner());

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSelectedButton();
                setVisible(false);
                dispose();

                MainFrame.getInstance().getLblText().setText(selected);
                MainFrame.getInstance().setVisible(true);
            }
        });
    }

    private void getSelectedButton() {
        for (Enumeration<AbstractButton> buttons = sort.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                selected = button.getText().split(" ")[0].toLowerCase();
                return;
            }
        }
        selected = "placeholder";
    }

    private void setButtonBackground() {
        for (Enumeration<AbstractButton> buttons = sort.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
        }
    }
}
