package ua.yaremechko.footballmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.yaremechko.footballmanager.model.FootballTeam;
import ua.yaremechko.footballmanager.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	List<Player> readByTeam(FootballTeam team);
}
