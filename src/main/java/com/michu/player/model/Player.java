package com.michu.player.model;

import lombok.Data;

@Data
public class Player {

    private String playerId;
    private String playerName;
    private Team team;
    private String image;
    private int shirtNumber;
    private String position;
    private String nation;
    private long marketValue;
    private int goals;
    private int matches;
    private int assists;
}
