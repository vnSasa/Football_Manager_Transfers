package ua.yaremechko.footballmanager.dto;

import ua.yaremechko.footballmanager.model.FootballTeam;

public class FootballTeamDto {

	private Long team_id;
	private String teamName;
	private String country;
	private Double accountBalance;
	private Double transferTax;

	public FootballTeamDto() {
	}

	public FootballTeamDto(FootballTeam footballTeam) {
		this.team_id = footballTeam.getTeam_id();
		this.teamName = footballTeam.getTeamName();
		this.country = footballTeam.getCountry();
		this.accountBalance = footballTeam.getAccountBalance();
		this.transferTax = footballTeam.getTransferTax();
	}

	public Long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Double getTransferTax() {
		return transferTax;
	}

	public void setTransferTax(Double transferTax) {
		this.transferTax = transferTax;
	}

}
