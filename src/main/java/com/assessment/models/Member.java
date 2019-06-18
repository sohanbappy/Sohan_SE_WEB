package com.assessment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="member_tb")
public class Member {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,
    generator="native")
	@GenericGenerator(
	name = "native",
	strategy = "native"
	)
	@Column(name="id")
	private int id;
	@Column(name="country_id")
	private String country;
	@Column(name="name")
	private String name;
	@Column(name="dob")
	private String dob;
	@Column(name="age")
	private String age;
	@Column(name="role")
	private String role;
	@Column(name="contact")
	private String contact;
	
	public Member() {
		super();
	}

	public Member(int id, String country, String name, String dob, String age, String role, String contact) {
		super();
		this.id = id;
		this.country = country;
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.role = role;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", country=" + country + ", name=" + name + ", dob=" + dob + ", age=" + age
				+ ", role=" + role + ", contact=" + contact + "]";
	}
	
	

}
