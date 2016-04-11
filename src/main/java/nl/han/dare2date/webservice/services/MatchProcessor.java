package nl.han.dare2date.webservice.services;

import nl.han.dare2date.service.web.applyregistration.model.CalculateResponse;
import nl.han.dare2date.webservice.model.Member;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.HashMap;
import java.util.List;

public class MatchProcessor implements Processor {

    private IMatchService matchService;

    public MatchProcessor() {
        this.matchService = new MatchService();
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Member> members = exchange.getProperty("otherMembers", List.class);
        HashMap<String, Number> spotifyResults = exchange.getProperty("spotifyMatchResults", HashMap.class);
        HashMap<String, Number> youtubeResults = exchange.getProperty("youtubeMatchResults", HashMap.class);
        CalculateResponse resp = new CalculateResponse();
        resp.setResultList(this.matchService.createResultList(members, spotifyResults, youtubeResults));
        exchange.getOut().setBody(resp);
    }
}
