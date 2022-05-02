package ua.yaremechko.footballmanager.validation.valid.team.impl;

import org.springframework.stereotype.Component;

import ua.yaremechko.footballmanager.model.FootballTeam;
import ua.yaremechko.footballmanager.validation.exceptions.team.TeamNameException;
import ua.yaremechko.footballmanager.validation.valid.team.TeamValidatorCreate;

@Component
public class TeamNameValidator implements TeamValidatorCreate {


	@Override
	public void validate(FootballTeam team) {
		if (team.getTeamName() == null || team.getTeamName().isEmpty()) {
            throw new TeamNameException("Name can't be null or empty!");
        }
	}
}
