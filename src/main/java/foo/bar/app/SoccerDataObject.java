package foo.bar.app;

public class SoccerDataObject {
    private Display display;

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
        display.onMeasurementsChanged();
    }

    public void appendDisplay(Display display) {
        this.display = display;
    }
}
