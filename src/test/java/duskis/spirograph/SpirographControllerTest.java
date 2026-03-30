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
        JTextField largeRfield = mock(JTextField.class);
        doReturn("210").when(largeRfield).getText();
        JTextField rfield = mock(JTextField.class);
        doReturn("65").when(rfield).getText();
        JTextField penDfield = mock(JTextField.class);
        doReturn("50").when(penDfield).getText();
        JTextField numStepsfield = mock(JTextField.class);
        doReturn("2600").when(numStepsfield).getText();
        JTextField anglefield = mock(JTextField.class);
        doReturn("0.006").when(anglefield).getText();

        SpirographController controller = new SpirographController(view,
                model,
                largeRfield,
                rfield,
                penDfield,
                numStepsfield,
                anglefield);

        //controller.updateModel(); calls it two times

        verify(model).setLargeRadius(210);
        verify(model).setSmallRadius(65);
        verify(model).setPenDistance(50);
        verify(model).setNumSteps(2600);
        verify(model).setAnglePerStep(0.006);
    }
}
