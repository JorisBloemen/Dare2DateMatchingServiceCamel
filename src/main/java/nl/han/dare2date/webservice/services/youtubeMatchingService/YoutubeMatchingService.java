package nl.han.dare2date.webservice.services.youtubeMatchingService;

import nl.han.dare2date.webservice.services.IAPIMatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class YoutubeMatchingService implements IAPIMatchingService {

    @Autowired
    private IYoutubeConnector youtubeConnector;

    public YoutubeMatchingService(){
        this.youtubeConnector = new YoutubeConnector();
    }

    public YoutubeMatchingService(IYoutubeConnector youtubeConnector){
        this.youtubeConnector = youtubeConnector;
    }

    @Override
    public HashMap<String, Number> calculateMatches(
            String id, ArrayList<String> possibleMatches) {
        HashMap<String, Number> result = new HashMap<String, Number>();
        ArrayList<String> baseFavoritesIds =
                this.youtubeConnector.getFavoritesTitlesByUserId(id);
        for(String possibleMatch : possibleMatches){
            int count = 0;
            ArrayList<String> favorites =
                    this.youtubeConnector.getFavoritesTitlesByUserId(
                            possibleMatch);
            for(String baseFavoriteId : baseFavoritesIds){
                for(String favoriteId : favorites){
                    if(baseFavoriteId.equals(favoriteId)){
                        count++;
                    }
                }
            }
            result.put(possibleMatch, count);
        }
        return result;
    }
}

