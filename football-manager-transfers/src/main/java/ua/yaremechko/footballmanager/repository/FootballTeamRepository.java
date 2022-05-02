package ua.yaremechko.footballmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.yaremechko.footballmanager.model.FootballTeam;

public interface FootballTeamRepository extends JpaRepository<FootballTeam, Long> {
	
}
