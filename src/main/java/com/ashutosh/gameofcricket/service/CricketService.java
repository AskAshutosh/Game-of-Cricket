package com.ashutosh.gameofcricket.service;

import com.ashutosh.gameofcricket.model.Team;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CricketService {

    public static void main(String[] args) throws IOException {

    }
    public void jsonToPojo() throws IOException {
        InputStream inputStream = new FileInputStream("team.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Team> teamList = objectMapper.readValue(inputStream, new TypeReference<>(){});
        for(Team t: teamList){

        }
    }
}
