package com.example.docker.service;

import com.example.docker.entity.Board;
import com.example.docker.repository.BoardRepository;
import com.example.dto.request.BoardRequest;
import com.example.dto.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void save(BoardRequest boardRequest) {
        Board board = boardRequest.toEntity();
        boardRepository.save(board);
    }

    @Override
    public List<BoardResponse> findAll() {
        List<BoardResponse> boards = new ArrayList<>();

        for(Board board : boardRepository.findAll()) {
             boards.add(BoardResponse.builder()
                             .id(board.getId())
                             .content(board.getContent())
                     .build());
        }

        return boards;
    }
}
