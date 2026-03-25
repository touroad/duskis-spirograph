package duskis.spirograph;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpirographControllerTest {
    @Test
    void updateModel() {
        SpirographView view = mock();
        JTextField largeRfield = mock();
        JTextField rfield = mock();
        JTextField penDfield2 = mock();
        JTextField numStepsfield2 = mock();
        JTextField anglefield2 = mock();

        SpirographController controller = new SpirographController(view,
                largeRfield,
                rfield,
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
