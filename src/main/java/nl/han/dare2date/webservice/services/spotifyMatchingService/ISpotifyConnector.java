package nl.han.dare2date.webservice.services.spotifyMatchingService;

import java.util.ArrayList;

public interface ISpotifyConnector {
    ArrayList<String> getPlaylistsIdByUserId(String userId);
}
