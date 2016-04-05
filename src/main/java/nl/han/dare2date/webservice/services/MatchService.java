package nl.han.dare2date.webservice.services;

import nl.han.dare2date.service.web.applyregistration.model.ComparedMember;
import nl.han.dare2date.service.web.applyregistration.model.ResultList;
import nl.han.dare2date.webservice.dao.IMemberDao;
import nl.han.dare2date.webservice.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MatchService implements IMatchService{

    @Autowired
    private IAPIMatchingService spotifyMatchingService;

    @Autowired
    private IAPIMatchingService youtubeMatchingService;

    @Autowired
    private IMemberDao memberDoa;

    @Override
    public ResultList getMatches(Long id) {
        Member member = this.memberDoa.getMember(id);
        List<Member> otherMembers = this.memberDoa.getOtherMembers(id);

        ArrayList<String> possibleSpotifyMatches = new ArrayList<String>();
        ArrayList<String> possibleYoutubeMatches = new ArrayList<String>();
        for(Member otherMember : otherMembers){
            possibleSpotifyMatches.add(otherMember.getSpotifyId());
            possibleYoutubeMatches.add(otherMember.getYoutubeId());
        }

        HashMap<String, Number> spotifyMatchResults =
                this.spotifyMatchingService.calculateMatches(
                        member.getSpotifyId(), possibleSpotifyMatches);

        HashMap<String, Number> youtubeMatchResults =
                this.youtubeMatchingService.calculateMatches(
                        member.getYoutubeId(), possibleYoutubeMatches);


        return createResultList(otherMembers, spotifyMatchResults, youtubeMatchResults);
    }

    private ResultList createResultList(List<Member> otherMembers,
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
}
