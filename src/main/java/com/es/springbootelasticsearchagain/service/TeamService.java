package com.es.springbootelasticsearchagain.service;

import com.es.springbootelasticsearchagain.domain.Team;
import com.es.springbootelasticsearchagain.dto.TeamRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.SearchHit;

import java.util.List;

public interface TeamService {

    Team save(TeamRequestDto teamRequestDto);

    void delete(String name);

    Team findOne(String id);


    List<Team> findByNameWithList(String name);

    List<Team> findByNameWithContains(String name);

}
