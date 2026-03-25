package org.example;

import javax.swing.*;
import java.awt.*;

public class SpirographView extends JComponent {
    private SpirographModel model = new SpirographModel(200, 75, 55, 8000, 0.007);

    public SpirographModel getModel() {
        return this.model;
    }

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

        double largeR = model.getLargeRadius();
        double r = model.getSmallRadius();
        double d = model.getPenDistance();
        int steps = model.getNumSteps();

        //time starts as 0, as i = 0 and angleperstep = 0
        double x1 = (largeR - r) * Math.cos(0) + d * Math.cos((largeR - r) * 0 / r);
        double y1 = (largeR - r) * Math.sin(0) - d * Math.sin((largeR - r) * 0 / r);

        for (int i = 1; i < currStep; i++) {
            float hue = (float) i / (float) steps;
            g.setColor(Color.getHSBColor(hue, 1.0f, 1.0f)); //slowly cycles through colors
            double time = i * model.getAnglePerStep();
            double x = (largeR - r) * Math.cos(time) + d * Math.cos((largeR - r) * time / r);
            double y = (largeR - r) * Math.sin(time) - d * Math.sin((largeR - r) * time / r);
            g.drawLine((int) x1, (int) y1, (int) x, (int) y);
            x1 = x;
            y1 = y;
        }
    }
}
