package com.michu.player.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.michu.player.model.Player;
import com.michu.player.services.PlayerService;
import org.springframework.stereotype.Service;


@Service
public class PlayerServiceImpl implements PlayerService {
    @Override
    public String getPlayerInfo(long playerId) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://transfermarkt-db.p.rapidapi.com/v1/players/info")
                .queryString("locale", "ES")
                .queryString("player_id", playerId)
                .header("x-rapidapi-key", "fe9b5bd5a6mshf3cd610816b3682p178cc9jsnda04eea22207")
                .header("x-rapidapi-host", "transfermarkt-db.p.rapidapi.com")
                .asString();

        return response.getBody();
    }

    @Override
    public String comparePlayers(long playerId1, long playerId2) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://transfermarkt-db.p.rapidapi.com/v1/players/compare?locale=DE&player_ids=276002%2C85298")
                .header("x-rapidapi-key", "fe9b5bd5a6mshf3cd610816b3682p178cc9jsnda04eea22207")
                .header("x-rapidapi-host", "transfermarkt-db.p.rapidapi.com")
                .asString();

        return response.getBody();
    }

    @Override
    public String top10Players() throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://transfermarkt-db.p.rapidapi.com/v1/players/images?player_ids=276002%2C85298%2C810895%2C533007%2C330659%2C824353%2C73013%2C523318%2C420884%2C533738&locale=DE")
                .header("x-rapidapi-key", "fe9b5bd5a6mshf3cd610816b3682p178cc9jsnda04eea22207")
                .header("x-rapidapi-host", "transfermarkt-db.p.rapidapi.com")
                .asString();
        return response.getBody();
    }

    private String compare(String playerInfo1, String playerInfo2) {
        // Convierte JSON a objetos de jugador
        Player player1 = convertJsonToPlayer(playerInfo1);
        Player player2 = convertJsonToPlayer(playerInfo2);

        // Realiza la comparación basada en estadísticas
        StringBuilder result = new StringBuilder();
        result.append("Comparación entre ").append(player1.getPlayerName()).append(" y ").append(player2.getPlayerName()).append(":\n");
        result.append("Goles: ").append(player1.getGoals()).append(" vs ").append(player2.getGoals()).append("\n");
        result.append("Asistencias: ").append(player1.getAssists()).append(" vs ").append(player2.getAssists()).append("\n");
        result.append("Partidos: ").append(player1.getMatches()).append(" vs ").append(player2.getMatches()).append("\n");

        return result.toString();
    }

    private Player convertJsonToPlayer(String playerJson) {
        // Implementa la lógica para convertir JSON a objeto Player
        // Usa una librería como Jackson o Gson
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(playerJson, Player.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
