package com.michu.player.controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.michu.player.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<String> getPlayerInfo(@PathVariable long playerId) throws UnirestException {
        return ResponseEntity.ok(playerService.getPlayerInfo(playerId));
    }

    @GetMapping("/comparison")
    public ResponseEntity<String> comparePlayer(@RequestParam long playerId1, @RequestParam long playerId2) throws UnirestException {
        return ResponseEntity.ok(playerService.comparePlayers(playerId1, playerId2));
    }

    // ESTE TOP TEN SOLO SACA EL ID DEL JUGADOR Y LA IMAGEN!!!!
    @GetMapping("/top10")
    public ResponseEntity<String> top10Players() throws UnirestException {
        return ResponseEntity.ok(playerService.top10Players());
    }

    @GetMapping("/squad/{squadId}")
    public ResponseEntity<String> getSquad(@PathVariable long squadId) throws UnirestException {
        return ResponseEntity.ok(playerService.getClubSquad(squadId));
    }
}
