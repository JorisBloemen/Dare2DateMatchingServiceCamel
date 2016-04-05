package nl.han.dare2date.webservice.services;

import java.util.ArrayList;
import java.util.HashMap;

public interface IAPIMatchingService {
    HashMap<String, Number> calculateMatches(
            String id, ArrayList<String> possibleMatches);
}
