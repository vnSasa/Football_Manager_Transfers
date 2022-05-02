package ua.yaremechko.footballmanager.validation.valid.player.impl;

import org.springframework.stereotype.Component;

import ua.yaremechko.footballmanager.model.Player;
import ua.yaremechko.footballmanager.validation.exceptions.player.PlayerAgeException;
import ua.yaremechko.footballmanager.validation.valid.player.PlayerValidatorCreate;

@Component
public class PlayerAgeValidator implements PlayerValidatorCreate {

	@Override
	public void validate(Player player) {
		if (player.getAge() <= 0) {
			throw new PlayerAgeException("Age can't be less than 0!");
		}
	}
}
