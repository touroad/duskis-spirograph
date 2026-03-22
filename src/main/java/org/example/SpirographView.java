package org.example;

import javax.swing.*;
import java.awt.*;

public class SpirographView extends JComponent {
    SpirographModel model = new SpirographModel(200, 75, 55, 8000, 0.007);

    private int currStep = 0;

    public void setCurr(int curr) {
        this.currStep = curr;
    }

    public void setModel(SpirographModel model) {
        this.model = model;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(getWidth() / 2, getHeight() / 2);

        //getting values so that lines don't get too long, numsteps and angle steps are used once so i wont do this for them
        double R = model.getLargeRadius();
        double r = model.getSmallRadius();
        double d = model.getPenDistance();
        int steps = model.getNumSteps();

        //time starts as 0, as i = 0 and angleperstep = 0
        double x1 = (R - r) * Math.cos(0) + d * Math.cos((R - r) * 0 / r);
        double y1 = (R - r) * Math.sin(0) - d * Math.sin((R - r) * 0 / r);

        for (int i = 1; i < currStep; i++) {
            float hue = (float) i / (float) steps;
            g.setColor(Color.getHSBColor(hue, 1.0f, 1.0f)); //had to look up how to do this
            double time = i * model.getAnglePerStep(); //should i just assign this? how much extra time does it take to compute this
            double x = (R - r) * Math.cos(time) + d * Math.cos((R - r) * time / r);
            double y = (R - r) * Math.sin(time) - d * Math.sin((R - r) * time / r);
            g.drawLine((int) x1, (int) y1, (int) x, (int) y);
            x1 = x;
            y1 = y;
        }
    }
}
