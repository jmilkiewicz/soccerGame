package foo.bar.app;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SoccerDataObject {
    private final Set<Display> displays = new CopyOnWriteArraySet<>();

    public int getGoalsTeamA(){
       return -1;
    }

    public int getGoalsTeamB(){
        return -1;
    }

    public int getCurrentMinute(){
        return -1;
    }

    public void measurementsChanged(){
        for (Display display : displays) {
            notifyDisplay(display);
        }

    }

    private void notifyDisplay(Display display) {
        try {
            display.onMeasurementsChanged(this);
        } catch (Exception ex){
            //TODO some logging,some action ...
        }
    }

    public void appendDisplay(Display display) {
        displays.add(display);
    }
}
