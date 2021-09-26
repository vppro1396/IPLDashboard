package com.vaibhav.ipldashboard.data;

import java.time.LocalDate;

import com.vaibhav.ipldashboard.model.Match;

import org.springframework.batch.item.ItemProcessor;


public class MatchDataProcessor implements ItemProcessor<MatchInput, Match>{


    @Override
    public Match process(final MatchInput matchInput) throws Exception{


        Match match11 = new Match();
        String count_strng  = matchInput.getId();
        Double d = Double.parseDouble(count_strng.trim());
        Long l = d.longValue();
        match11.setId(l);
        match11.setId(Long.parseLong(matchInput.getId()));
        match11.setCity(matchInput.getCity());

        match11.setDate(LocalDate.parse(matchInput.getDate()));
        match11.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match11.setVenue(matchInput.getVenue());

        String firstInningsTeam, secondInningsTeam;

        if("bat".equals(matchInput.getToss_decision())){

            firstInningsTeam = matchInput.getToss_winner();     
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) 
            ? matchInput.getTeam2() : matchInput.getTeam1(); 
        }
        else{

            secondInningsTeam = matchInput.getToss_winner();
            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) 
            ? matchInput.getTeam2() : matchInput.getTeam1();
        }

        match11.setTeam1(firstInningsTeam);
        match11.setTeam2(secondInningsTeam);
        match11.setTossWinner(matchInput.getToss_winner());
        match11.setTossDecision(matchInput.getToss_decision());
        match11.setResult(matchInput.getResult());
        match11.setResultMargin(matchInput.getResult_margin());
        match11.setUmpire1(matchInput.getUmpire1());
        match11.setUmpire2(matchInput.getUmpire2());
        match11.setMatchWinner(matchInput.getWinner());

        return match11;
    }
    
}
