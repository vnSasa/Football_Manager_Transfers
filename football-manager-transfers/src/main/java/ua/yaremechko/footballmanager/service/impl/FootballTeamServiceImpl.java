package ua.yaremechko.footballmanager.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.yaremechko.footballmanager.dto.FootballTeamDto;
import ua.yaremechko.footballmanager.model.FootballTeam;
import ua.yaremechko.footballmanager.repository.FootballTeamRepository;
import ua.yaremechko.footballmanager.service.FootballTeamService;
import ua.yaremechko.footballmanager.validation.exceptions.team.TeamNotFoundException;
import ua.yaremechko.footballmanager.validation.valid.team.TeamValidatorCreate;

@Service
public class FootballTeamServiceImpl implements FootballTeamService {

	@Autowired
	private FootballTeamRepository teamRepository;
	@Autowired
	private List<TeamValidatorCreate> teamValidatorCreates;

	@Autowired
	public FootballTeamServiceImpl(FootballTeamRepository teamRepository,
			List<TeamValidatorCreate> teamValidatorCreates) {
		this.teamRepository = teamRepository;
		this.teamValidatorCreates = teamValidatorCreates;
	}

	@Override
	public FootballTeamDto create(FootballTeamDto teamDto) {
		FootballTeam team = map(teamDto);
		for (TeamValidatorCreate createValidator : teamValidatorCreates) {
            createValidator.validate(team);
        }
		teamRepository.save(team);
		return map(team);
	}

	@Override
	public FootballTeamDto readById(Long team_id) {
		Optional<FootballTeam> team = teamRepository.findById(team_id);
		if (team.isPresent()) {
			return map(team.get());
		}
		throw new TeamNotFoundException("Team with id " + team_id + " not found!");
	}

	@Override
	public List<FootballTeamDto> readAll() {
		List<FootballTeam> teams = teamRepository.findAll();
		return teams.stream().map(this::map).collect(Collectors.toList());
	}

	@Override
	public FootballTeamDto update(FootballTeamDto teamDto) {
		readById(teamDto.getTeam_id());
		return create(teamDto);
	}

	@Override
	@Transactional(rollbackOn = TeamNotFoundException.class)
	public void delete(Long team_id) {
		FootballTeamDto teamDto = readById(team_id);
		if (teamDto == null) {
			throw new TeamNotFoundException("Team not found!!!");
		}
		teamRepository.deleteById(team_id);
	}

	@Override
	public FootballTeam map(FootballTeamDto teamDto) {
		FootballTeam team = new FootballTeam();
		team.setTeam_id(teamDto.getTeam_id());
		team.setTeamName(teamDto.getTeamName());
		team.setCountry(teamDto.getCountry());
		team.setAccountBalance(teamDto.getAccountBalance());
		team.setTransferTax(teamDto.getTransferTax());
		return team;
	}

	@Override
	public FootballTeamDto map(FootballTeam team) {
		return new FootballTeamDto(team);
	}

}
