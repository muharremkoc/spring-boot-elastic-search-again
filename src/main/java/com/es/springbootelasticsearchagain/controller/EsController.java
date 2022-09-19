package com.es.springbootelasticsearchagain.controller;

import com.es.springbootelasticsearchagain.domain.Team;
import com.es.springbootelasticsearchagain.dto.TeamRequestDto;
import com.es.springbootelasticsearchagain.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/es")
@RequiredArgsConstructor
public class EsController {

    final TeamService teamService;

    @PostMapping("/team")
    Team postTeam(@RequestBody TeamRequestDto teamRequestDto){
        return teamService.save(teamRequestDto);
    }


    @DeleteMapping("/team/{search}")
    void deleteTeam(@PathVariable("search") String name){
        teamService.delete(name);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Team>> getTeam(@PathVariable("search") String search){
        return ResponseEntity.ok(teamService.findByNameWithList(search));
    }

    //Name  alanının içerisinde  arama yapmak için Örn => team = "Java" gelen deger = "Ja"
    @GetMapping("/team/contains/{search}")
    public ResponseEntity<List<Team>> getContainsTeam(@PathVariable String search){
        return ResponseEntity.ok(teamService.findByNameWithContains(search));
    }
    }
