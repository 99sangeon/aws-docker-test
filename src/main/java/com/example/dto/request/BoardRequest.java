package com.example.dto.request;

import com.example.docker.entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequest {
    private String content;

    public Board toEntity() {
        return Board.builder()
                .content(this.content)
                .build();
    }
}
