package com.hnln.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentTable")
public class Student {
	// By default class name will be Table name
	// If we want to explicitly name the table, we use @Table annotation
	
	@Id // To create primary key, we add @Id annotation
	@Column(name = "SID") // Explicitly name the column
	private Integer sid;
	
	@Column(name = "SNAME")
	private String sName;
	
	@Column(name = "SCITY")
	private String scity;

	
	// Mandatory zero parameterized constructor
	public Student() {
		super();
		System.out.println("Zero parametarized constructor!");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", scity=" + scity + "]";
	}
	
	
	
	
}
