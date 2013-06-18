package de.peter_neumaier.repository;

import org.springframework.data.repository.CrudRepository;

import de.pneumaier.sportevents.domain.Competition;

public interface CompetitionRepository extends CrudRepository<Competition, Long> {

}
