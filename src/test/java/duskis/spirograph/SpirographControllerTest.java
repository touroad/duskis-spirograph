package duskis.spirograph;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpirographControllerTest {
    @Test
    void updateModel() {
        SpirographView view = mock(SpirographView.class);
        SpirographModel model = mock(SpirographModel.class);
        JTextField largeRfield = mock();
        doReturn("210").when(largeRfield).getText();
        JTextField rfield = mock();
        doReturn("65").when(rfield).getText();
        JTextField penDfield = mock();
        doReturn("50").when(penDfield).getText();
        JTextField numStepsfield = mock();
        doReturn("2600").when(numStepsfield).getText();
        JTextField anglefield = mock();
        doReturn("0.006").when(anglefield).getText();

        SpirographController controller = new SpirographController(view,
                model,
                largeRfield,
                rfield,
                penDfield,
                numStepsfield,
                anglefield);

        controller.updateModel();

        verify(model).setLargeRadius(210);
        assertEquals(210, model.getLargeRadius());
        assertEquals(65, model.getSmallRadius());
        assertEquals(50, model.getPenDistance());
        assertEquals(2600, model.getNumSteps());
        assertEquals(0.006, model.getAnglePerStep());
    }
}
