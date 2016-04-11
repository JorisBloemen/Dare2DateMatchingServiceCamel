package nl.han.dare2date.webservice.dao;

import nl.han.dare2date.webservice.model.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberDao implements IMemberDao {

    @PersistenceContext
    private EntityManagerFactory emf;

    @Transactional
    @Override
    public Member getMember(long id){
        this.emf = Persistence.createEntityManagerFactory("calculator");
        return emf.createEntityManager().find(Member.class, id);
    }

    @Override
    public List<Member> getOtherMembers(long id){
        return emf.createEntityManager().createQuery(
                "select m from Member m where m.id is not :id")
                .setParameter("id", id)
                .getResultList();
    }
}
