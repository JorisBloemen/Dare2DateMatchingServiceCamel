package nl.han.dare2date.webservice.services.spotifyMatchingService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.when;

public class SpotifyMatchingServiceTest {
    private SpotifyMatchingService spotifyMatchingService;
    private SpotifyConnector mockedConnector;

    @Before
    public void setUp() throws Exception {
        this.mockedConnector = Mockito.mock(SpotifyConnector.class);
        this.spotifyMatchingService = new SpotifyMatchingService(mockedConnector);

        ArrayList<String> testList1 = new ArrayList<>();
        testList1.add("playlist1");
        when(mockedConnector.getPlaylistsIdByUserId("1")).thenReturn(testList1);

        ArrayList<String> testList2 = new ArrayList<>();
        testList2.add("playlist1");
        when(mockedConnector.getPlaylistsIdByUserId("2")).thenReturn(testList2);

        ArrayList<String> testList3 = new ArrayList<>();
        testList3.add("playlist2");
        when(mockedConnector.getPlaylistsIdByUserId("3")).thenReturn(testList3);
    }

    @Test
    public void calculateMatchesSuccesfull() throws Exception {
        ArrayList<String> otherMembersList = new ArrayList<>();
        otherMembersList.add("2");
        otherMembersList.add("3");

        HashMap<String, Number> matchResult = new HashMap<>();
        matchResult.put("2", 1);
        matchResult.put("3", 0);
        assertEquals(matchResult,
                spotifyMatchingService.calculateMatches("1", otherMembersList));
    }

    @Test
    public void calculateMatchesFailed() throws Exception {
        ArrayList<String> otherMembersList = new ArrayList<>();
        otherMembersList.add("2");
        otherMembersList.add("3");

        HashMap<String, Number> matchResult = new HashMap<>();
        matchResult.put("2", 10);
        matchResult.put("3", 0);
        assertNotSame(matchResult,
                spotifyMatchingService.calculateMatches("1", otherMembersList));
    }
}
