package com.example.app.model;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "PROBLEM_SOLVED_DOCUMENT")
public class ProblemSolvedDocument {

	@SequenceGenerator(name = "generator", sequenceName = "ID_SEQ_PL_CATEGORY",allocationSize = 1,initialValue = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "ID")
	private Long id;
	
	@Lob
	@Column(name = "FILE")
	private byte[] file;
	
	@Cascade({ 
		CascadeType.DELETE
	})
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "PL_CATEGORY_ID", foreignKey = @ForeignKey(name = "FK_PL_CATEGORY_PROBLEM_SOLVED_DOCUMENT", value = ConstraintMode.CONSTRAINT))
	private PrograminLangueCategory programinLangueCategory;
	
	public ProblemSolvedDocument() {
		// TODO Auto-generated constructor stub
	}

}
