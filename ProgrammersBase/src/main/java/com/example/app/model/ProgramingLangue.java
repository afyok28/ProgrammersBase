package com.example.app.model;

import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name = "PROGRAMING_LANGUE")
public class ProgramingLangue {

	@SequenceGenerator(name = "generator",sequenceName = "ID_SEQ_PROGRAMING_LANGUE")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="generator" )
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 35 ,unique = true)
	private String name;

	@Lob
	@Column(name = "IMAGE")
	private byte[] image;
	
	public ProgramingLangue() {
		
	}

	public ProgramingLangue(Long id, String name, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}
	public ProgramingLangue(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.image = null;
	}
	public ProgramingLangue(String name, byte[] image) {
		super();
		this.name = name;
		this.image = image;
	}
	public ProgramingLangue(String name) {
		super();
		this.name = name;
		this.image = null;
	}
	public ProgramingLangue(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProgramingLangue [id=" + id + ", name=" + name + ", image=" + Arrays.toString(image) + "]";
	}

}
