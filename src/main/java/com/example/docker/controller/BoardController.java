package com.example.docker.controller;

import com.example.docker.service.BoardService;
import com.example.dto.request.BoardRequest;
import com.example.dto.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardResponse> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardRequest boardRequest) {
        boardService.save(boardRequest);
        return "redirect:/boards/list";
    }
}
