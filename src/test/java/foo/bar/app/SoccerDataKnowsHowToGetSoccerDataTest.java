package foo.bar.app;

import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SoccerDataKnowsHowToGetSoccerDataTest {
    private GameDataClient gameDataClientMock = Mockito.mock(GameDataClient.class);
    private SoccerDataObject soccerDataObject = new SoccerDataObject(gameDataClientMock);


    @Test
    public void shouldFetchGoalOfTeamsA() throws Exception {
        when(gameDataClientMock.getGoalsTeamA()).thenReturn(3);

        int goalsTeamA = soccerDataObject.getGoalsTeamA();

        assertThat(goalsTeamA, is(3));
        verify(gameDataClientMock).getGoalsTeamA();
    }

    @Test
    public void shouldFetchGoalOfTeamsB() throws Exception {
        when(gameDataClientMock.getGoalsTeamB()).thenReturn(1);

        int goalsTeamB = soccerDataObject.getGoalsTeamB();

        assertThat(goalsTeamB, is(1));
        verify(gameDataClientMock).getGoalsTeamB();
    }

    @Test
    public void shouldFetchCurrentMinute() throws Exception {
        when(gameDataClientMock.getCurrentMinute()).thenReturn(77);

        int goalsTeamB = soccerDataObject.getCurrentMinute();

        assertThat(goalsTeamB, is(77));
        verify(gameDataClientMock).getCurrentMinute();
    }
}
