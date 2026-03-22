package org.example;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpirographController {
    private final SpirographView spirographView;
    private final JTextField Rfield;
    private final JTextField rfield;
    private final JTextField penDfield;
    private final JTextField numStepsfield;
    private final JTextField anglefield;

    private AtomicBoolean stopRunnable;

    public SpirographController(SpirographView spirographView,
                                JTextField Rfield,
                                JTextField rfield,
                                JTextField penDfield,
                                JTextField numStepsfield,
                                JTextField anglefield) {
        this.spirographView = spirographView;
        this.Rfield = Rfield;
        this.rfield = rfield;
        this.penDfield = penDfield;
        this.numStepsfield = numStepsfield;
        this.anglefield = anglefield;
        updateModel();
    }


    public void updateModel() {
        spirographView.model.setLargeRadius(Double.parseDouble(Rfield.getText()));
        spirographView.model.setSmallRadius(Double.parseDouble(rfield.getText()));
        spirographView.model.setPenDistance(Double.parseDouble(penDfield.getText()));
        spirographView.model.setNumSteps(Integer.parseInt(numStepsfield.getText()));
        spirographView.model.setAnglePerStep(Double.parseDouble(anglefield.getText()));
    }

    public void startAnimation() {
        if (this.stopRunnable != null) {
            this.stopRunnable.set(true);
        }

        final AtomicBoolean stopper = new AtomicBoolean(false);
        this.stopRunnable = stopper;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int curr = 1; curr < spirographView.model.getNumSteps(); curr++) {
                    if (stopper.get()) {
                        break;
                    }
                    spirographView.setCurr(curr);
                    spirographView.repaint();
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
