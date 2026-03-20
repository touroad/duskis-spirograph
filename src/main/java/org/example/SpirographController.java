package org.example;

import javax.swing.*;

public class SpirographController {
    private SpirographView spirographView;
    private JLabel largeR;
    private JLabel smallr;
    private JLabel penDistance;
    private JLabel numSteps;
    private JLabel angleSteps;

    private JTextField Rfield;
    private JTextField rfield;
    private JTextField penDfield;
    private JTextField numStepsfield;
    private  JTextField anglefield;

    public SpirographController(SpirographView spirographView,
                                JLabel largeR,
                                JLabel smallr,
                                JLabel penDistance,
                                JLabel numSteps,
                                JLabel angleSteps,
                                JTextField Rfield,
                                JTextField rfield,
                                JTextField penDfield,
                                JTextField numStepsfield,
                                JTextField anglefield) {
        this.spirographView = spirographView;
        this.largeR = largeR;
        this.smallr = smallr;
        this.penDistance = penDistance;
        this.numSteps = numSteps;
        this.angleSteps = angleSteps;
        this.Rfield = Rfield;
        this.rfield = rfield;
        this.penDfield = penDfield;
        this.numStepsfield = numStepsfield;
        this.anglefield = anglefield;
    }

    /*
    public void updateDraw(JTextField Rfield,
                           JTextField rfield,
                           JTextField penDfield,
                           JTextField numStepsfield,
                           JTextField anglefield){
        spirographView.setDraw();
    }
     */
}
