package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SpirographFrame extends JFrame {
    public SpirographFrame(){
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
                largeR,
                smallr,
                penDistance,
                numSteps,
                angleSteps,
                Rfield,
                rfield,
                penDfield,
                numStepsfield,
                anglefield);

        spirographView.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton button = new JButton("Draw");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.updateDraw(Rfield, rfield, penDfield, numStepsfield, anglefield);
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
    }

    public static void main(String[] args) {
        SpirographFrame frame = new SpirographFrame();
        frame.setVisible(true);
    }
}
