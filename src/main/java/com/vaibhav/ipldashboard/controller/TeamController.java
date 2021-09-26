package com.vaibhav.ipldashboard.controller;

import com.vaibhav.ipldashboard.model.Team;
import com.vaibhav.ipldashboard.repository.MatchRepository;
import com.vaibhav.ipldashboard.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {
    
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;


    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team =  teamRepository.findByTeamName(teamName);
            team.setMatches(matchRepository.findLatestMatchesByteam(teamName, 4));

        return team;
    }
}
