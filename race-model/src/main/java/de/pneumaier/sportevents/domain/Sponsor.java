package de.pneumaier.sportevents.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sponsor 
{
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String homepage;
	private String emblem;
}
