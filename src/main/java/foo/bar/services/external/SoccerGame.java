package foo.bar.services.external;

import foo.bar.app.GameDataClient;

public class SoccerGame implements GameDataClient{
    @Override
    public int getGoalsTeamA() {
        //TODO to implement
        throw new UnsupportedOperationException();
    }

    @Override
    public int getGoalsTeamB() {
        //TODO to implement
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCurrentMinute() {
        //TODO to implement
        throw new UnsupportedOperationException();
    }
}
