package org.example;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpirographControllerTest {
    @Test
    void updateModel() {
        SpirographView view = new SpirographView();
        JTextField Rfield2 = new JTextField("210");
        JTextField rfield2 = new JTextField("65");
        JTextField penDfield2 = new JTextField("50");
        JTextField numStepsfield2 = new JTextField("2600");
        JTextField anglefield2 = new JTextField("0.006");

        SpirographController controller = new SpirographController(view,
                Rfield2,
                rfield2,
                penDfield2,
                numStepsfield2,
                anglefield2);

        controller.updateModel();

        SpirographModel model = view.getModel();

        assertEquals(210, model.getLargeRadius());
        assertEquals(65, model.getSmallRadius());
        assertEquals(50, model.getPenDistance());
        assertEquals(2600, model.getNumSteps());
        assertEquals(0.006, model.getAnglePerStep());
    }
}
