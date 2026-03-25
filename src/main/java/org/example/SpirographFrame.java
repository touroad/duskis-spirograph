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

        setLayout(new GridBagLayout());

        JLabel largeR = new JLabel("largeRadius: ");
        JLabel smallr = new JLabel("smallRadius: ");
        JLabel penDistance = new JLabel("penDistance: ");
        JLabel numSteps = new JLabel("numSteps: ");
        JLabel angleSteps = new JLabel("anglePerStep: ");
        SpirographView spirographView = new SpirographView();


        JTextField largeRfield = new JTextField("200");
        JTextField rfield = new JTextField("75");
        JTextField penDfield = new JTextField("55");
        JTextField numStepsfield = new JTextField("8000");
        JTextField anglefield = new JTextField("0.007");

        SpirographController controller = new SpirographController(spirographView,
                largeRfield,
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


        GridBagConstraints constraints;

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(largeR, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(largeRfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(smallr, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(rfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(penDistance, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 5;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(penDfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 6;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(numSteps, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 7;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(numStepsfield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 8;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(angleSteps, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 9;
        constraints.gridy = 1;
        constraints.weighty = 0;
        add(anglefield, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 10;
        constraints.gridy = 1;
        constraints.weighty = 0;
        constraints.weightx = 0;
        add(button, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 11;
        constraints.weightx = 0;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.SOUTH;
        add(spirographView, constraints);

        controller.startAnimation();
    }

    public static void main(String[] args) {
        SpirographFrame frame = new SpirographFrame();
        frame.setVisible(true);
    }
}
