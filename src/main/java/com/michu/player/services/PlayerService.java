package com.michu.player.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {

    String getPlayerInfo(long playerId) throws UnirestException;

    String comparePlayers(long playerId1, long playerId2) throws UnirestException;
}
