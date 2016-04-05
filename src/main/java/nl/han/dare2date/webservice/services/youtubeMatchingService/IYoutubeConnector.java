package nl.han.dare2date.webservice.services.youtubeMatchingService;

import java.util.ArrayList;

public interface IYoutubeConnector {
    ArrayList<String> getFavoritesTitlesByUserId(String userId);
}
