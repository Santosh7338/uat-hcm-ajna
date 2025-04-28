package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name ="EVALUATION_FRAMEWORK")
public class Evaluation_Framework {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eva_ch_seq")
	@SequenceGenerator(name = "eva_ch_seq", sequenceName ="EVALUATION_CHILD_SEQ", allocationSize = 1)
	@Column(name = "EVAL_FRAMEWORK_ID")
	private int eval_framework_id;
}
