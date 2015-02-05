package foo.bar.app;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SoccerDataObject {
    private final Set<Display> displays = new CopyOnWriteArraySet<>();
    private final GameDataClient gameDataClient;

    public SoccerDataObject(GameDataClient gameDataClient) {
        this.gameDataClient = gameDataClient;
    }

    public int getGoalsTeamA(){
       return gameDataClient.getGoalsTeamA();
    }

    public int getGoalsTeamB(){
        return gameDataClient.getGoalsTeamB();
    }

    public int getCurrentMinute(){
        return gameDataClient.getCurrentMinute();
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
