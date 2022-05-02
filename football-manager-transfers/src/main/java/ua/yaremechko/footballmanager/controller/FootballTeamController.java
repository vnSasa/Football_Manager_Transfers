package ua.yaremechko.footballmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import ua.yaremechko.footballmanager.dto.FootballTeamDto;
import ua.yaremechko.footballmanager.service.FootballTeamService;

@RestController
@RequestMapping("/football-team")
public class FootballTeamController {

	@Autowired
	private FootballTeamService service;

	@Autowired
	public FootballTeamController(FootballTeamService footballTeamService) {
		this.service = footballTeamService;
	}

	@GetMapping("/all")
	public List<FootballTeamDto> getAllTeams() {
		return service.readAll();
	}

	@GetMapping("/{id}")
	public FootballTeamDto getTeamById(@PathVariable Long id) {
		return service.readById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FootballTeamDto create(@Valid @RequestBody FootballTeamDto teamDto) {
		return service.create(teamDto);
	}

	@PutMapping
	public FootballTeamDto update(@PathVariable Long id,
			@Valid @RequestBody FootballTeamDto teamDTO) {
		return service.update(teamDTO);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
