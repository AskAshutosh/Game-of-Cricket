package com.ashutosh.gameofcricket.service;

import com.ashutosh.gameofcricket.model.Team;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CricketService {

    public static void main(String[] args) throws IOException {

    }
    public void jsonToPojo() throws IOException {
        InputStream inputStream = new FileInputStream("team.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Team team = objectMapper.readValue(inputStream, Team.class);

    }
}
