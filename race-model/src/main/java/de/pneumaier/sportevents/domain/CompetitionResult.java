package de.pneumaier.sportevents.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CompetitionResult  implements Serializable
{

	private static final long serialVersionUID = -7594702233967699522L;
	
	@Id @GeneratedValue
	private Long id;
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<CompetitorResult> results;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<CompetitorResult> getResults() {
		return results;
	}
	public void setResults(List<CompetitorResult> results) {
		this.results = results;
	}
	public void addResult(CompetitorResult result){
		if(results == null){
			results = new ArrayList<CompetitorResult>();
		}
		results.add(result);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
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
		CompetitionResult other = (CompetitionResult) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}
	
	
}
