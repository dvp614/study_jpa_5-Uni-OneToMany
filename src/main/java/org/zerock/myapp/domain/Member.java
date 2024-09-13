package org.zerock.myapp.domain;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.*;

import org.zerock.myapp.listener.CommonEntityLifecycleListener;

import lombok.Data;


@Data


@EntityListeners(CommonEntityLifecycleListener.class)
@Entity(name = "Member")
public class Member implements Serializable {
	@Serial private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_MEMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "member_id")
	private Long id;
	
	private String name;
} // end class
