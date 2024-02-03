package com.example.dto.response;

import com.example.docker.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardResponse {
    private Long id;
    private String content;

    public BoardResponse of(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .content(board.getContent())
                .build();
    }
}
