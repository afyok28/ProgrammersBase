package com.example.app.model;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "PROBLEM_SOLVED")
public class ProblemSolved {

	@SequenceGenerator(name = "generator", sequenceName = "ID_SEQ_PL_CATEGORY")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TOPIC", length = 35)
	private String topic;
	
	@Column(name = "DESCRIPTION", length = 50)
	private String description;
	
	@Column(name = "LINK", length = 200)
	private String link;
	
	@Cascade({ 
		CascadeType.DELETE
	})
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "PL_CATEGORY_ID", foreignKey = @ForeignKey(name = "FK_PL_CATEGORY_PROBLEM_SOLVED", value = ConstraintMode.CONSTRAINT))
	private PrograminLangueCategory programinLangueCategory;
	
	public ProblemSolved() {
		// TODO Auto-generated constructor stub
	}

}
