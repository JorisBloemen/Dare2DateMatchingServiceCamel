package nl.han.dare2date.webservice.dao;

import nl.han.dare2date.service.web.applyregistration.model.CalculateRequest;
import nl.han.dare2date.webservice.model.Member;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;

public class MemberDaoProcessor implements Processor {

    private IMemberDao memberDao;

    public MemberDaoProcessor(){
        this.memberDao = new MemberDao();
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        Long id = exchange.getIn().getBody(CalculateRequest.class).getId();

        Member member = this.memberDao.getMember(id);
        List<Member> otherMembers = this.memberDao.getOtherMembers(id);
        exchange.setProperty("member", member);
        exchange.setProperty("otherMembers", otherMembers);
    }
}
