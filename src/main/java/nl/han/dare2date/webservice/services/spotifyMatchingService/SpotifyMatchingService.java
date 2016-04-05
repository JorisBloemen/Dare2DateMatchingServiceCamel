package nl.han.dare2date.webservice.services.spotifyMatchingService;

import nl.han.dare2date.webservice.services.IAPIMatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SpotifyMatchingService implements IAPIMatchingService{

    @Autowired
    private ISpotifyConnector spotifyConnector;

    public SpotifyMatchingService(){
        this.spotifyConnector = new SpotifyConnector();
    }

    public SpotifyMatchingService(ISpotifyConnector spotifyConnector){
        this.spotifyConnector = spotifyConnector;
    }

    @Override
    public HashMap<String, Number> calculateMatches(
            String id, ArrayList<String> possibleMatches) {
        HashMap<String, Number> result = new HashMap<String, Number>();
        ArrayList<String> basePlaylistIds =
                this.spotifyConnector.getPlaylistsIdByUserId(id);
        for(String possibleMatch : possibleMatches){
            int count = 0;
            ArrayList<String> playlists =
                    this.spotifyConnector.getPlaylistsIdByUserId(possibleMatch);
            for(String basePlaylistId : basePlaylistIds){
                for(String playlistId : playlists){
                    if(basePlaylistId.equals(playlistId)){
                        count++;
                    }
                }
            }
            result.put(possibleMatch, count);
        }
        return result;
    }
}
