package ua.yaremechko.footballmanager.validation.valid.player.impl;

import org.springframework.stereotype.Component;

import ua.yaremechko.footballmanager.model.Player;
import ua.yaremechko.footballmanager.validation.exceptions.player.PlayerFullNameException;
import ua.yaremechko.footballmanager.validation.valid.player.PlayerValidatorCreate;

@Component
public class PlayerNameValidator implements PlayerValidatorCreate {

	@Override
	public void validate(Player player) {
		if (player.getFullName() == null || player.getFullName().isEmpty()) {
			throw new PlayerFullNameException("Name can't be null");
		}
	}
}
