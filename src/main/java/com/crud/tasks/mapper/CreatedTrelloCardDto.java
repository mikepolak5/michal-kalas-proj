package com.crud.tasks.mapper;

import com.crud.tasks.domain.BadgesDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCardDto {

    public CreatedTrelloCardDto(String id, String name, String shortUrl) {
        this.id = id;
        this.name = name;
        this.shortUrl = shortUrl;
    }

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;

    @JsonProperty("badges")
    private BadgesDto badgesDto;
}
