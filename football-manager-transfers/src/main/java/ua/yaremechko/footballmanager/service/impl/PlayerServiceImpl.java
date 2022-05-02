package ua.yaremechko.footballmanager.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.yaremechko.footballmanager.dto.FootballTeamDto;
import ua.yaremechko.footballmanager.dto.PlayerDto;
import ua.yaremechko.footballmanager.model.FootballTeam;
import ua.yaremechko.footballmanager.model.Player;
import ua.yaremechko.footballmanager.repository.PlayerRepository;
import ua.yaremechko.footballmanager.service.FootballTeamService;
import ua.yaremechko.footballmanager.service.PlayerService;
import ua.yaremechko.footballmanager.validation.exceptions.player.PlayerNotFoundException;
import ua.yaremechko.footballmanager.validation.valid.player.PlayerValidatorCreate;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private FootballTeamService teamService;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private List<PlayerValidatorCreate> playerValidatorCreates;

	@Autowired
	public PlayerServiceImpl(FootballTeamService teamService, PlayerRepository playerRepository,
			List<PlayerValidatorCreate> playerValidatorCreates) {
		this.teamService = teamService;
		this.playerRepository = playerRepository;
		this.playerValidatorCreates = playerValidatorCreates;
	}

	@Override
	public PlayerDto create(PlayerDto playerDto) {
		Player player = map(playerDto);
		for (PlayerValidatorCreate validator : playerValidatorCreates) {
            validator.validate(player);
        }
		playerRepository.save(player);
		return map(player);
	}

	@Override
	public PlayerDto readById(Long player_id) {
		Optional<Player> player = playerRepository.findById(player_id);
		if (player.isPresent()) {
			return map(player.get());
		}
		throw new PlayerNotFoundException("Player with id " + player_id + " not found!!!");
	}

	@Override
	public List<PlayerDto> readAll() {
		List<Player> players = playerRepository.findAll();
		return players.stream().map(this::map).collect(Collectors.toList());
	}

	@Override
	public PlayerDto update(PlayerDto playerDto) {
		readById(playerDto.getId());
		return create(playerDto);
	}

	@Override
	public void delete(Long player_id) {
		PlayerDto playerDto = readById(player_id);
		if (playerDto == null) {
			throw new PlayerNotFoundException("Player with id " + player_id + " not found!!!");
		}
		playerRepository.deleteById(player_id);
	}

	public double sumTransfer(PlayerDto playerDto) {
		double priceTransfer = playerDto.getMonthsOfExperience() * 100000 / playerDto.getAge();
		double commission = (int) (priceTransfer / 100 * playerDto.getTeamDto().getTransferTax());
		return priceTransfer + commission;
	}

	@Override
	public void transfer(Long player_id, Long team_id) {
		Player player = map(readById(player_id));
		FootballTeam newTeam = teamService.map(teamService.readById(team_id));
		if (player.getTeam().equals(newTeam)) {
			throw new IllegalArgumentException("This player has already in this team!!!");
		}
		double totalPrice = sumTransfer(map(player));
		if (newTeam.getAccountBalance() < totalPrice) {
			throw new IllegalArgumentException("The team does not have enough funds to acquire this player!!!");
		}
		FootballTeam oldTeam = player.getTeam();
		oldTeam.setAccountBalance(player.getTeam().getAccountBalance() + totalPrice);
		newTeam.setAccountBalance(newTeam.getAccountBalance() - totalPrice);
		player.setTeam(newTeam);
		teamService.update(teamService.map(newTeam));
		teamService.update(teamService.map(oldTeam));
		update(map(player));
	}

	@Override
	public Player map(PlayerDto playerDto) {
		Player player = new Player();
		player.setPlayer_id(playerDto.getId());
		player.setFullName(playerDto.getFullName());
		player.setAge(playerDto.getAge());
		player.setMonthsOfExperience(playerDto.getMonthsOfExperience());
		player.setNationality(playerDto.getNationality());
		player.setTeam(teamService.map(playerDto.getTeamDto()));
		return player;
	}

	@Override
	public PlayerDto map(Player player) {
		return new PlayerDto(player);
	}

	@Override
	public List<PlayerDto> findByTeam(FootballTeamDto teamDto) {
		List<Player> players = playerRepository.readByTeam(teamService.map(teamDto));
		return players.stream().map(this::map).collect(Collectors.toList());
	}

}
