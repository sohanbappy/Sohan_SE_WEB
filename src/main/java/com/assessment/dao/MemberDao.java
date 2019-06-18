package com.assessment.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assessment.models.Member;


@Repository
public interface  MemberDao extends JpaRepository<Member, Integer>{

	
}
