package com.es.springbootelasticsearchagain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequestDto {

    String name;
    String coachName;
}
