package com.demo.jpa.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TourPackage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	@Column
	private String name;

	@OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL)
	private List<Tour> tours;

	public TourPackage() {

	}

	public TourPackage(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
