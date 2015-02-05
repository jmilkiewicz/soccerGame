package foo.bar.app;


import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class SoccerDataObjectNotifiesDisplaysTest {
    private Display mockDisplay = Mockito.mock(Display.class);
    private Display mockDisplay2 = Mockito.mock(Display.class);
    private Display mockDisplay3 = Mockito.mock(Display.class);

    @Test
    public void shallNotifyASingleDisplayOnMeasurementsChanged() throws Exception {
        SoccerDataObject soccerDataObject = new SoccerDataObject();
        soccerDataObject.appendDisplay(mockDisplay);

        soccerDataObject.measurementsChanged();

        verify(mockDisplay).onMeasurementsChanged(soccerDataObject);
    }


    @Test
    public void shallNotifyAMultipleDisplayOnMeasurementsChanged() throws Exception {
        SoccerDataObject soccerDataObject = new SoccerDataObject();
        soccerDataObject.appendDisplay(mockDisplay);
        soccerDataObject.appendDisplay(mockDisplay2);
        soccerDataObject.appendDisplay(mockDisplay3);

        soccerDataObject.measurementsChanged();

        verify(mockDisplay).onMeasurementsChanged(soccerDataObject);
        verify(mockDisplay2).onMeasurementsChanged(soccerDataObject);
        verify(mockDisplay3).onMeasurementsChanged(soccerDataObject);
    }

}
