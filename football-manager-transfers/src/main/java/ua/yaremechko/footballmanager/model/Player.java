package ua.yaremechko.footballmanager.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long player_id;
	private String fullName;
	private Integer age;
	private Integer monthsOfExperience;
	private String nationality;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private FootballTeam team;

	public Player() {
	}

	public Player(Long player_id, String fullName, Integer age, Integer monthsOfExperience, String nationality,
			FootballTeam team) {
		this.player_id = player_id;
		this.fullName = fullName;
		this.age = age;
		this.monthsOfExperience = monthsOfExperience;
		this.nationality = nationality;
		this.team = team;
	}

	public Player(String fullName, Integer age, Integer monthsOfExperience, String nationality, FootballTeam team) {
		this.fullName = fullName;
		this.age = age;
		this.monthsOfExperience = monthsOfExperience;
		this.nationality = nationality;
		this.team = team;
	}

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getMonthsOfExperience() {
		return monthsOfExperience;
	}

	public void setMonthsOfExperience(Integer monthsOfExperience) {
		this.monthsOfExperience = monthsOfExperience;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public FootballTeam getTeam() {
		return team;
	}

	public void setTeam(FootballTeam team) {
		this.team = team;
	}

}
