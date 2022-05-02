package ua.yaremechko.footballmanager.dto;

import ua.yaremechko.footballmanager.model.Player;

public class PlayerDto {

	private Long id;
	private String fullName;
	private Integer age;
	private Integer monthsOfExperience;
	private String nationality;
	private FootballTeamDto teamDto;

	public PlayerDto() {
	}

	public PlayerDto(Player player) {
		this.id = player.getPlayer_id();
		this.fullName = player.getFullName();
		this.age = player.getAge();
		this.monthsOfExperience = player.getMonthsOfExperience();
		this.nationality = player.getNationality();
		this.teamDto = new FootballTeamDto(player.getTeam());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public FootballTeamDto getTeamDto() {
		return teamDto;
	}

	public void setTeamDto(FootballTeamDto teamDto) {
		this.teamDto = teamDto;
	}

}
