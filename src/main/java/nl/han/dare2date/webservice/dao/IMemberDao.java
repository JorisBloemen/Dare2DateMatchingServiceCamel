package nl.han.dare2date.webservice.dao;

import nl.han.dare2date.webservice.model.Member;

import java.util.List;

public interface IMemberDao {
    Member getMember (long id);
    List<Member> getOtherMembers(long id);
}
