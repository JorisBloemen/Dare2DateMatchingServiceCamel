package nl.han.dare2date.webservice.services;

import nl.han.dare2date.service.web.applyregistration.model.ComparedMember;
import nl.han.dare2date.service.web.applyregistration.model.ResultList;
import nl.han.dare2date.webservice.model.Member;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

@Service
public class MatchService implements IMatchService, Processor {


    public ResultList createResultList(List<Member> otherMembers,
                                        HashMap<String, Number> spotifyMatchResults,
                                        HashMap<String, Number> youtubeMatchResults){
        ResultList resultList = new ResultList();
        for(int i = 0; i < otherMembers.size(); i++){
            ComparedMember cm = new ComparedMember();
            cm.setId(otherMembers.get(i).getId());
            cm.setSpotifyMatchCount(BigInteger.valueOf(
                    spotifyMatchResults
                            .get(otherMembers
                                    .get(i)
                                    .getSpotifyId())
                            .intValue()));
            cm.setYoutubeMatchCount(BigInteger.valueOf(
                    youtubeMatchResults
                            .get(otherMembers
                                    .get(i)
                                    .getYoutubeId())
                            .intValue()
            ));
            resultList.getComparedMember().add(cm);
        }
        return resultList;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

    }
}
