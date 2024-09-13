package org.zerock.myapp.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.zerock.myapp.listener.CommonEntityLifecycleListener;

import lombok.Data;


@Data


@EntityListeners(CommonEntityLifecycleListener.class)
@Entity(name = "Team")
@Table(name= "team")
public class Team implements Serializable { // Parent, One(1)
	@Serial private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private Long id;
	
	@Basic(optional = false)
	private String name;

//	@OneToMany(targetEntity = Member.class, cascade = CascadeType.ALL)
	@OneToMany(targetEntity = Member.class)
	/**
	* -------------------------------
	* @JoinColumn
	* -------------------------------
	* (1) Set the FK column name of Many (Child) table. (***)
	* (2) If @JoinColumn annotation abbreviated,
	*       The default FK column name = 
	*          The name of the entity + "_" + The name of the referenced primary key column.
	* (3) @JoinColumn(table): The name of the table that contains the FK column.
	*       If `table` propery *Not specified,
	*       The FK column is assumed to be in the primary table of the applicable entity. 
	* -------------------------------
	*/
//	@JoinColumn
	@JoinColumn(
			name = "my_team", 
			referencedColumnName = "team_id")
	private List<Member> members = new ArrayList<>();
	
} // end class

