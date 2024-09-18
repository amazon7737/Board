package org.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.board.domain.BoardVO;
import org.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@Slf4j
public class BoardController {


    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/list")
    public String list(Model model){
        log.info(boardService.list().get(0).getContent());
        model.addAttribute("boardList", boardService.list());
        return "list";
    }

    @RequestMapping(value = "/read/{seq}")
    public String read(Model model, @PathVariable int seq){
        model.addAttribute("boardVO", boardService.read(seq));
        return "read";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(){
        return "write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write( BoardVO boardVO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/write";
        }else{
        log.info("data: {}", boardVO.getTitle());
        boardService.write(boardVO);
        return "redirect:/list";
        }
    }




}
