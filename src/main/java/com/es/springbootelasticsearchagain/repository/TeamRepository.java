package com.es.springbootelasticsearchagain.repository;

import com.es.springbootelasticsearchagain.domain.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TeamRepository extends ElasticsearchRepository<Team,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Team> getByCustomQuery(String search);

    List<Team> findByNameContaining(String search);
}
