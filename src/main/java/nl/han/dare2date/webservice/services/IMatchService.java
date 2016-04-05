package nl.han.dare2date.webservice.services;

import nl.han.dare2date.service.web.applyregistration.model.ResultList;

public interface IMatchService {

    ResultList getMatches(Long id);
}
