package nl.han.dare2date.webservice.services.youtubeMatchingService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.when;


public class YoutubeMatchingServiceTest {
    private YoutubeMatchingService youtubeMatchingService;
    private YoutubeConnector mockedConnector;

    @Before
    public void setUp() throws Exception {
        this.mockedConnector = Mockito.mock(YoutubeConnector.class);
        this.youtubeMatchingService = new YoutubeMatchingService(mockedConnector);

        ArrayList<String> testList1 = new ArrayList<>();
        testList1.add("video1");
        when(mockedConnector.getFavoritesTitlesByUserId("1")).thenReturn(testList1);

        ArrayList<String> testList2 = new ArrayList<>();
        testList2.add("video1");
        when(mockedConnector.getFavoritesTitlesByUserId("2")).thenReturn(testList2);

        ArrayList<String> testList3 = new ArrayList<>();
        testList3.add("video2");
        when(mockedConnector.getFavoritesTitlesByUserId("3")).thenReturn(testList3);
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
                youtubeMatchingService.calculateMatches("1", otherMembersList));
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
                youtubeMatchingService.calculateMatches("1", otherMembersList));
    }
}
