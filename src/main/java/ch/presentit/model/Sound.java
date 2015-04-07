package ch.presentit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sound")
public class Sound {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
}
