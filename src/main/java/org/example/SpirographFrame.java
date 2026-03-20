package org.example;

import javax.swing.*;
import java.awt.*;

public class SpirographFrame extends JFrame {
    public SpirographFrame(){
        setSize(300, 400);
        setTitle("Gravity Frames");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //IMPORTANT, thus tells it to close when you hit the x button

        setLayout(new BorderLayout());

        JTextField largeR = new JTextField("largeRadius: ");
        JTextField smallr = new JTextField("smallRadius: ");
        JTextField penDistance = new JTextField("penDistance: ");
        JTextField numSteps = new JTextField("numSteps: ");
        JTextField angleSteps = new JTextField("anglePerStep: ");

        JTextField Rfeild = new JTextField("200");
        JTextField rfeild = new JTextField("75");
        JTextField penDfield = new JTextField("55");
        JTextField numStepsfield = new JTextField("8000");
        JTextField anglefield = new JTextField("0.007");

    }
}
