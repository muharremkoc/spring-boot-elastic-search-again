package com.es.springbootelasticsearchagain.service;

import com.es.springbootelasticsearchagain.domain.Team;
import com.es.springbootelasticsearchagain.dto.TeamRequestDto;
import com.es.springbootelasticsearchagain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{

    private static final String INDEX_NAME = "erp";

    private final TeamRepository teamRepository;

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public Team save(TeamRequestDto teamRequestDto) {
        Team team=Team.builder()
                .name(teamRequestDto.getName())
                .coachName(teamRequestDto.getCoachName()).build();
        return teamRepository.save(team);
    }

    @Override
    public void delete(String name) {
        List<Team> teams=teamRepository.getByCustomQuery(name);
        teams.forEach(teamRepository::delete);
    }

    @Override
    public Team findOne(String id) {
        return teamRepository.findById(id).get();    }

    @Override
    public List<Team> findByNameWithList(String name) {
        List<Team> teams=teamRepository.getByCustomQuery(name);
        return teams;
    }

    @Override
    public List<Team> findByNameWithContains(String name) {
        List<Team> teams=teamRepository.findByNameContaining(name);
    return teams;
    }


}
