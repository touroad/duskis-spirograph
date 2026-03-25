package duskis.spirograph;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpirographController {
    private final SpirographView spirographView;
    private final SpirographModel model;
    private final JTextField largeRfield;
    private final JTextField rfield;
    private final JTextField penDfield;
    private final JTextField numStepsfield;
    private final JTextField anglefield;

    private AtomicBoolean stopRunnable;

    public SpirographController(SpirographView spirographView,
                                SpirographModel model,
                                JTextField largeRfield,
                                JTextField rfield,
                                JTextField penDfield,
                                JTextField numStepsfield,
                                JTextField anglefield) {
        this.spirographView = spirographView;
        this.model = model;
        this.largeRfield = largeRfield;
        this.rfield = rfield;
        this.penDfield = penDfield;
        this.numStepsfield = numStepsfield;
        this.anglefield = anglefield;
        updateModel();
    }


    public void updateModel() {
        model.setLargeRadius(Double.parseDouble(largeRfield.getText()));
        model.setSmallRadius(Double.parseDouble(rfield.getText()));
        model.setPenDistance(Double.parseDouble(penDfield.getText()));
        model.setNumSteps(Integer.parseInt(numStepsfield.getText()));
        model.setAnglePerStep(Double.parseDouble(anglefield.getText()));
    }

    public void startAnimation() {
        if (this.stopRunnable != null) {
            this.stopRunnable.set(true);
        }

        final AtomicBoolean stopper = new AtomicBoolean(false);
        this.stopRunnable = stopper;
        //this code is responsible for running the animation loop.
        //without it multiple animation loops will try to run at once making it glitchy
        //it is cool and atomic booleans are more reaching i think

        Runnable runnable = new Runnable() {
            SpirographModel model = spirographView.getModel();

            //should i instead set temp on top?
            @Override
            public void run() {
                for (int curr = 1; curr < model.getNumSteps(); curr++) {
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
