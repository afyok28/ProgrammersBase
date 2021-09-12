package com.example.app.model;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "PL_CATEGORY")
public class PrograminLangueCategory {

	@SequenceGenerator(name = "generator", sequenceName = "ID_SEQ_PL_CATEGORY", allocationSize = 1, initialValue = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "ID")
	private Long id;

	@Column(name = "TOPIC", length = 35)
	private String topic;

	@Cascade({ CascadeType.DELETE })
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "PL_ID", foreignKey = @ForeignKey(name = "FK_PLCATEGORY_PL", value = ConstraintMode.CONSTRAINT))
	private ProgramingLangue programingLangue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public ProgramingLangue getProgramingLangue() {
		return programingLangue;
	}

	public void setProgramingLangue(ProgramingLangue programingLangue) {
		this.programingLangue = programingLangue;
	}

	public PrograminLangueCategory() {
		// TODO Auto-generated constructor stub
	}

	public PrograminLangueCategory(Long id, String topic, ProgramingLangue programingLangue) {
		super();
		this.id = id;
		this.topic = topic;
		this.programingLangue = programingLangue;
	}
	public PrograminLangueCategory(Long id, String topic) {
		super();
		this.id = id;
		this.topic = topic;
	}

	public PrograminLangueCategory(String topic, ProgramingLangue programingLangue) {
		super();
		this.topic = topic;
		this.programingLangue = programingLangue;
	}

	public PrograminLangueCategory(String topic) {
		super();
		this.topic = topic;
	}
	public PrograminLangueCategory(Long id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "PrograminLangueCategory [id=" + id + ", topic=" + topic + ", programingLangue=" + programingLangue
				+ "]";
	}

}