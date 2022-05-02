package ua.yaremechko.footballmanager.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "football_teams")
public class FootballTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long team_id;
	private String teamName;
	private String country;
	private Double accountBalance;
	private Double transferTax;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
	private Set<Player> players;

	public FootballTeam() {
	}

	public FootballTeam(Long team_id, String teamName, String country, Double accountBalance, Double transferTax,
			Set<Player> players) {
		super();
		this.team_id = team_id;
		this.teamName = teamName;
		this.country = country;
		this.accountBalance = accountBalance;
		this.transferTax = transferTax;
		this.players = players;
	}

	public FootballTeam(String teamName, String country, Double accountBalance, Double transferTax,
			Set<Player> players) {
		this.teamName = teamName;
		this.country = country;
		this.accountBalance = accountBalance;
		this.transferTax = transferTax;
		this.players = players;
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

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

}
