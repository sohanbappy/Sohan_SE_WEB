package com.assessment.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assessment.dao.MemberDao;
import com.assessment.models.Member;



@Service
public class MemberService {

	@Autowired
	private  MemberDao memberDao;
	
	public  Member createMember(Member mem) {
		return memberDao.save(mem);
	}

	public  Iterable<Member> createMembers(List<Member> memberList) {
		Iterable<Member> list = memberDao.saveAll(memberList);
		return list;
	}
	
	public  Iterable<Member> findAllMembers() {
		Iterable<Member> list = memberDao.findAll();
		return list;
	}
	
	
	public  void deleteMember(Member mem) {
		memberDao.delete(mem);
	}

	public Member getMemberInfo(int id) {
			
		Member mem = memberDao.getOne(id);
		return mem;
		
	}
	
	@PersistenceContext
    EntityManager entityManager;
    public int countMember(String name) {
        Query query = entityManager.createNativeQuery("SELECT count(*) FROM team_db.member_tb WHERE country_id= ?", Member.class);
        query.setParameter(1, name);
        return query.getFirstResult();
    }
	
	
	


}
