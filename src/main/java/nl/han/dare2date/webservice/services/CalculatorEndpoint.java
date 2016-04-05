package nl.han.dare2date.webservice.services;

import nl.han.dare2date.service.web.applyregistration.model.CalculateRequest;
import nl.han.dare2date.service.web.applyregistration.model.CalculateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

    @Autowired
    private IMatchService matchService;

    public CalculatorEndpoint() {
    }

    @PayloadRoot(localPart = "CalculateRequest", namespace = "http://www.han.nl/schemas/messages")
    @ResponsePayload
    public CalculateResponse calculateSumForName(@RequestPayload CalculateRequest req) {
        CalculateResponse resp = new CalculateResponse();
        resp.setResultList(this.matchService.getMatches(req.getId()));
        return resp;
    }
}
