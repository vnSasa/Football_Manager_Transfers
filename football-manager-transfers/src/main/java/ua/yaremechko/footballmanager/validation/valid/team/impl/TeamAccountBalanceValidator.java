package ua.yaremechko.footballmanager.validation.valid.team.impl;

import org.springframework.stereotype.Component;

import ua.yaremechko.footballmanager.model.FootballTeam;
import ua.yaremechko.footballmanager.validation.exceptions.team.TeamAccountBalanceException;
import ua.yaremechko.footballmanager.validation.valid.team.TeamValidatorCreate;

@Component
public class TeamAccountBalanceValidator implements TeamValidatorCreate {

	@Override
	public void validate(FootballTeam team) {
		if (team.getAccountBalance() == null || team.getAccountBalance() < 0) {

            throw new TeamAccountBalanceException("Balance can't be null or less than 0!");
        }
	}
}
