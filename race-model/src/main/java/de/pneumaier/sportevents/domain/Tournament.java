package de.pneumaier.sportevents.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tournament 
{
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String description;
	@OneToMany
	private List<Sponsor> sponsors;
	@OneToMany
	private List<Competition> competitions;
}
