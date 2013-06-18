package de.peter_neumaier.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.pneumaier.sportevents.domain.Competition;

@Test
@ContextConfiguration(classes=RepositoryConfig.class)
public class TestDBService extends AbstractTestNGSpringContextTests {

	@Autowired
	private CompetitionRepository competitionRepository;
	
	@Test
	public void testCompetitionRepository() {
		Competition competition = new Competition();
		competition.setName("Malzini Bike Biathlon");
		Competition competitionSaved = competitionRepository.save(competition);
		assertNotNull(competitionSaved);
		assertNotNull(competitionSaved.getId());
		assertEquals(competitionSaved.getName(), "Malzini Bike Biathlon");
		
		Competition competitionLoaded = competitionRepository.findOne(competitionSaved.getId());
		
		System.out.println(competitionSaved.equals(competitionLoaded));
		
		assertEquals(competitionSaved, competitionLoaded);
		
		competitionLoaded.setName("Bike Biathlon");
		competitionRepository.save(competitionLoaded);
		
		Competition competitionLoaded2 = competitionRepository.findOne(competitionSaved.getId());
		assertEquals(competitionLoaded2, competitionLoaded);
		
		assertEquals(competitionRepository.count(), 1);
		competitionRepository.delete(competitionLoaded2);
		assertEquals(competitionRepository.count(), 0);
	}
}
