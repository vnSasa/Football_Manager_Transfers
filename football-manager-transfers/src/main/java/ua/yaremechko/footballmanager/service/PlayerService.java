package ua.yaremechko.footballmanager.service;

import java.util.List;

import ua.yaremechko.footballmanager.dto.FootballTeamDto;
import ua.yaremechko.footballmanager.dto.PlayerDto;
import ua.yaremechko.footballmanager.model.Player;

public interface PlayerService {

	PlayerDto create(PlayerDto playerDto);
	
	PlayerDto readById(Long player_id);
	
	List<PlayerDto> readAll();
	
	PlayerDto update(PlayerDto playerDto);
	
	void delete(Long player_id);
	
	void transfer(Long player_id, Long team_id);
	
	Player map(PlayerDto playerDto);
	
	PlayerDto map(Player player);
	
	List<PlayerDto> findByTeam(FootballTeamDto teamDto);
	
}
