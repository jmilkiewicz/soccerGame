package foo.bar.app;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SoccerDataObject {
    private Set<Display> displays = new HashSet<>();

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
