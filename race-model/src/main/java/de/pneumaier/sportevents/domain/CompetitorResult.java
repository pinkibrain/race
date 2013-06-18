package de.pneumaier.sportevents.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

@Entity
public class CompetitorResult  implements Serializable, Comparable<CompetitorResult>
{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	private int position;
	@ManyToOne
	private Competitor competitor;
	@OneToMany
	private List<SingleResult> results;
	@OneToMany
	private List<SingleResult> extraResults;
	private String unit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Competitor getCompetitor() {
		return competitor;
	}
	public void setCompetitor(Competitor competitor) {
		this.competitor = competitor;
	}
	public List<SingleResult> getResults() {
		return results;
	}
	public void setResults(List<SingleResult> results) {
		this.results = results;
	}
	public void addResult(SingleResult singleResult) {
		if(results == null){
			results = new LinkedList<SingleResult>();
		}
		results.add(singleResult);
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public List<SingleResult> getExtraResults() {
		return extraResults;
	}
	public void setExtraResults(List<SingleResult> extraResults) {
		this.extraResults = extraResults;
	}
	public void addExtraAmount(SingleResult extraSingleResult) {
		if(extraResults == null) {
			extraResults = new LinkedList<SingleResult>();
		}
		extraResults.add(extraSingleResult);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((competitor == null) ? 0 : competitor.hashCode());
		result = prime * result
				+ ((extraResults == null) ? 0 : extraResults.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + position;
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		CompetitorResult other = (CompetitorResult) obj;
		if (competitor == null) {
			if (other.competitor != null)
				return false;
		} else if (!competitor.equals(other.competitor))
			return false;
		if (extraResults == null) {
			if (other.extraResults != null)
				return false;
		} else if (!extraResults.equals(other.extraResults))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (position != other.position)
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
	
	public int compareTo(CompetitorResult o) {
		if(o == null){
			return 1;
		}
		return o.position - this.position;
	}
}
