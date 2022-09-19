package com.es.springbootelasticsearchagain.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Builder
@Document(indexName = "mysearch")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Team {


    @Id
    String id;
    String name;
    String coachName;

}
