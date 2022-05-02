package ua.yaremechko.footballmanager.validation.valid.team.impl;

import org.springframework.stereotype.Component;

import ua.yaremechko.footballmanager.model.FootballTeam;
import ua.yaremechko.footballmanager.validation.exceptions.team.TeamTransferTaxException;
import ua.yaremechko.footballmanager.validation.valid.team.TeamValidatorCreate;

@Component
public class TeamTransferTaxValidator implements TeamValidatorCreate {
    
	@Override
	public void validate(FootballTeam team) {
		if (team.getTransferTax() < 0 || team.getTransferTax() > 10) {

            throw new TeamTransferTaxException("Commission can't be less than 0 or more than 10");
        }
	}
}
