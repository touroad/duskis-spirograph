package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpirographFrame extends JFrame {
    public SpirographFrame() {
        setSize(300, 400);
        setTitle("Spirograph");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel largeR = new JLabel("largeRadius: ");
        JLabel smallr = new JLabel("smallRadius: ");
        JLabel penDistance = new JLabel("penDistance: ");
        JLabel numSteps = new JLabel("numSteps: ");
        JLabel angleSteps = new JLabel("anglePerStep: ");

        JTextField Rfield = new JTextField("200");
        JTextField rfield = new JTextField("75");
        JTextField penDfield = new JTextField("55");
        JTextField numStepsfield = new JTextField("8000");
        JTextField anglefield = new JTextField("0.007");

        SpirographView spirographView = new SpirographView();
        add(spirographView, BorderLayout.CENTER);

        SpirographController controller = new SpirographController(spirographView,
                Rfield,
                rfield,
                penDfield,
                numStepsfield,
                anglefield);

        JButton button = new JButton("Draw");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.updateModel();
                controller.startAnimation();
            }
        });

        JPanel southPanel = new JPanel();
        southPanel.add(largeR);
        southPanel.add(Rfield);
        southPanel.add(smallr);
        southPanel.add(rfield);
        southPanel.add(penDistance);
        southPanel.add(penDfield);
        southPanel.add(numSteps);
        southPanel.add(numStepsfield);
        southPanel.add(angleSteps);
        southPanel.add(anglefield);
        southPanel.add(button);

        add(southPanel, BorderLayout.SOUTH);
        controller.startAnimation();
    }

    public static void main(String[] args) {
        SpirographFrame frame = new SpirographFrame();
        frame.setVisible(true);
    }
}
