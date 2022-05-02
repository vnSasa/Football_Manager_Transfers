package ua.yaremechko.footballmanager.service;

import java.util.List;

import ua.yaremechko.footballmanager.dto.FootballTeamDto;
import ua.yaremechko.footballmanager.model.FootballTeam;

public interface FootballTeamService {

	FootballTeamDto create(FootballTeamDto teamDto);
	
	FootballTeamDto readById(Long team_id);
	
	List<FootballTeamDto> readAll();
	
	FootballTeamDto update(FootballTeamDto teamDto);
	
	void delete(Long team_id);
	
	FootballTeam map(FootballTeamDto teamDto);
	
	FootballTeamDto map(FootballTeam team);
	
}
