package com.example.docker.service;

import com.example.dto.request.BoardRequest;
import com.example.dto.response.BoardResponse;

import java.util.List;

public interface BoardService {
    void save(BoardRequest boardRequest);

    List<BoardResponse> findAll();
}
