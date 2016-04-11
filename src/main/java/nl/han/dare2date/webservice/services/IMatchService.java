package nl.han.dare2date.webservice.services;

import nl.han.dare2date.service.web.applyregistration.model.ResultList;
import nl.han.dare2date.webservice.model.Member;

import java.util.HashMap;
import java.util.List;

public interface IMatchService {

    ResultList createResultList(List<Member> otherMembers,
                                HashMap<String, Number> spotifyMatchResults,
                                HashMap<String, Number> youtubeMatchResults);
}
