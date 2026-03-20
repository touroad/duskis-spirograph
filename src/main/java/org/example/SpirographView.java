package org.example;

import javax.swing.*;
import java.awt.*;

public class SpirographView extends JComponent {
    SpirographModel draw = new SpirographModel(200,75,55,8000,0.007);

    public void setDraw(SpirographModel draw){
        this.draw = draw;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(getWidth()/2, getHeight()/2);

        //getting values so that lines don't get too long, numsteps and angle steps are used once so i wont do this for them
        double R = draw.getLargeRadius();
        double r = draw.getSmallRadius();
        double d = draw.getPenDistance();

        //time starts as 0, as i = 0 and angleperstep = 0
        double x1 = (R - r) * Math.cos(0) + d * Math.cos((R - r) * 0 / r);
        double y1 = (R - r) * Math.sin(0) - d * Math.sin((R - r) * 0 / r);

        for(int i = 1; i < draw.getNumSteps(); i++){
            double time = i * draw.getAnglePerStep();
            double x = (R - r) * Math.cos(time) + d * Math.cos((R - r) * time / r);
            double y = (R - r) * Math.sin(time) - d * Math.sin((R - r) * time / r);
            g.drawLine((int)x1, (int)y1, (int)x, (int)y);
            x1 = x;
            y1 = y;
        }
    }
}
