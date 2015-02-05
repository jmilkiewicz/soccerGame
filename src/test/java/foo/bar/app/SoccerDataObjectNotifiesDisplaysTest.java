package foo.bar.app;


import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class SoccerDataObjectNotifiesDisplaysTest {
    private Display mockDisplay = Mockito.mock(Display.class);

    @Test
    public void shallNotifyASingleDisplayOnMeasurementsChanged() throws Exception {
        SoccerDataObject soccerDataObject = new SoccerDataObject();
        soccerDataObject.appendDisplay(mockDisplay);

        soccerDataObject.measurementsChanged();

        verify(mockDisplay).onMeasurementsChanged(soccerDataObject);
    }

}
