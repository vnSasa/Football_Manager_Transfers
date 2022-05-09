package ua.yaremechko.footballmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ua.yaremechko.footballmanager.dto.PlayerDto;
import ua.yaremechko.footballmanager.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService service;

	@Autowired
    public PlayerController(PlayerService playerService) {
        this.service = playerService;
    }

    @GetMapping("/all")
    public List<PlayerDto> getAllPlayers() {
    	return service.readAll();
    }
    
    @GetMapping("/{id}")
    public PlayerDto getPlayerById(@PathVariable Long id) {
        return service.readById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PlayerDto savePlayer(@Valid @RequestBody PlayerDto playerDto) {
        return service.create(playerDto);
    }
    
    @PostMapping("/transfer")
    public void transfer(@RequestParam Long player_id,
                               @RequestParam Long team_id) {
        service.transfer(player_id, team_id);
    }

    @PutMapping("/{id}")
    public PlayerDto updatePlayer(@PathVariable Long id,
                                  @Valid @RequestBody PlayerDto playerDTO) {
        return service.update(playerDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        service.delete(id);
    }

    
	
}
