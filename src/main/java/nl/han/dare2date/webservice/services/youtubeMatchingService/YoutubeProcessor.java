package nl.han.dare2date.webservice.services.youtubeMatchingService;

import nl.han.dare2date.webservice.model.Member;
import nl.han.dare2date.webservice.services.IAPIMatchingService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YoutubeProcessor implements Processor {

    private IAPIMatchingService youtubeMatchingService;

    public YoutubeProcessor(){
        this.youtubeMatchingService = new YoutubeMatchingService();
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String spotifyId = exchange.getProperty("member", Member.class).getSpotifyId();
        List<Member> otherMembers = exchange.getProperty("otherMembers", List.class);

        ArrayList<String> otherMemberIds = new ArrayList<String>();
        HashMap<String, Number> result = new HashMap<String, Number>();

        for(Member member : otherMembers){
            otherMemberIds.add(member.getYoutubeId());
        }

        exchange.setProperty("youtubeMatchResults",
                youtubeMatchingService.calculateMatches(
                        spotifyId, otherMemberIds));

    }
}
