package com.assessment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="country_tb")
public class Country {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,
    generator="native")
	@GenericGenerator(
	name = "native",
	strategy = "native"
	)
	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	public Country() {
		super();
	}

	public Country(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
