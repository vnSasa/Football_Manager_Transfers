package ua.yaremechko.footballmanager.validation.valid.team.impl;

import org.springframework.stereotype.Component;

import ua.yaremechko.footballmanager.model.FootballTeam;
import ua.yaremechko.footballmanager.validation.exceptions.team.TeamCountryException;
import ua.yaremechko.footballmanager.validation.valid.team.TeamValidatorCreate;

@Component
public class TeamCountryValidator implements TeamValidatorCreate {

	@Override
	public void validate(FootballTeam team) {
		if (team.getCountry() == null || team.getCountry().isEmpty()) {
			throw new TeamCountryException("Country can't be null or empty!");
		}
	}
}
