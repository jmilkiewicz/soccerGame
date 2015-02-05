package foo.bar.app;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SoccerDataKnowsHowToGetGameDataTest {
    public static final int A_TEAM_GOALS = 3;
    public static final int B_TEAM_GOALS = 1;
    public static final int CURRENT_MINUTE = 77;
    private GameDataClient gameDataClientMock = Mockito.mock(GameDataClient.class);
    private SoccerDataObject soccerDataObject = new SoccerDataObject(gameDataClientMock);


    @Before
    public void setUp() throws Exception {
        when(gameDataClientMock.getGoalsTeamA()).thenReturn(A_TEAM_GOALS);
        when(gameDataClientMock.getGoalsTeamB()).thenReturn(B_TEAM_GOALS);
        when(gameDataClientMock.getCurrentMinute()).thenReturn(CURRENT_MINUTE);
    }

    @Test
    public void shouldFetchGoalOfTeamsA() throws Exception {
        int goalsTeamA = soccerDataObject.getGoalsTeamA();

        assertThat(goalsTeamA, is(A_TEAM_GOALS));
        verify(gameDataClientMock).getGoalsTeamA();
    }

    @Test
    public void shouldFetchGoalOfTeamsB() throws Exception {
        int goalsTeamB = soccerDataObject.getGoalsTeamB();

        assertThat(goalsTeamB, is(B_TEAM_GOALS));
        verify(gameDataClientMock).getGoalsTeamB();
    }

    @Test
    public void shouldFetchCurrentMinute() throws Exception {
        int goalsTeamB = soccerDataObject.getCurrentMinute();

        assertThat(goalsTeamB, is(CURRENT_MINUTE));
        verify(gameDataClientMock).getCurrentMinute();
    }
}
