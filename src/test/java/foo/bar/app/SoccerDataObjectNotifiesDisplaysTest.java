package foo.bar.app;


import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SoccerDataObjectNotifiesDisplaysTest {
    private Display mockDisplay = Mockito.mock(Display.class);
    private Display mockDisplay2 = Mockito.mock(Display.class);

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

        soccerDataObject.measurementsChanged();

        verify(mockDisplay).onMeasurementsChanged(soccerDataObject);
        verify(mockDisplay2).onMeasurementsChanged(soccerDataObject);
    }

    @Test
    public void shallAlwaysNotifyAllDisplaysInCaseOfDisplayException() throws Exception {
        SoccerDataObject soccerDataObject = new SoccerDataObject();
        soccerDataObject.appendDisplay(mockDisplay);
        soccerDataObject.appendDisplay(mockDisplay2);
        doThrow(new RuntimeException()).when(mockDisplay).onMeasurementsChanged(Matchers.<SoccerDataObject>anyObject());
        doThrow(new RuntimeException()).when(mockDisplay2).onMeasurementsChanged(Matchers.<SoccerDataObject>anyObject());

        soccerDataObject.measurementsChanged();

        verify(mockDisplay).onMeasurementsChanged(soccerDataObject);
        verify(mockDisplay2).onMeasurementsChanged(soccerDataObject);
    }

}
