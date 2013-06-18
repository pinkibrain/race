package de.pneumaier.sportevents.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Competition  implements Serializable
{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	private String name;
	@OneToMany
	private List<Competitor> competitors;
	@OneToOne
	private CompetitionResult competitionResult;
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
	public List<Competitor> getCompetitors() {
		return competitors;
	}
	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}
	public CompetitionResult getCompetitionResult() {
		return competitionResult;
	}
	public void setCompetitionResult(CompetitionResult competitonResult) {
		this.competitionResult = competitonResult;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((competitionResult == null) ? 0 : competitionResult.hashCode());
		result = prime * result
				+ ((competitors == null) ? 0 : competitors.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competition other = (Competition) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
