package ua.yaremechko.footballmanager.validation.valid.player.impl;

import org.springframework.stereotype.Component;

import ua.yaremechko.footballmanager.model.Player;
import ua.yaremechko.footballmanager.validation.exceptions.player.PlayerMonthOfExperienceException;
import ua.yaremechko.footballmanager.validation.valid.player.PlayerValidatorCreate;

@Component
public class PlayerExperienceValidator implements PlayerValidatorCreate {

	@Override
	public void validate(Player player) {
		if (player.getMonthsOfExperience() < 0) {
			throw new PlayerMonthOfExperienceException("Experience can't be less than 0!");
		}
	}
}
