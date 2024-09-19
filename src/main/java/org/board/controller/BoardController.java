package org.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.board.domain.BoardVO;
import org.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Arrays;
import java.util.HashMap;

@Controller
@SessionAttributes("boardVO")
@Slf4j
public class BoardController {


    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/list")
    public String list(Model model){
//        log.info(boardService.list().get(0).getContent());
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
    public String write(@RequestParam HashMap<String, String> info, HttpServletRequest request){
//        log.info("data: {}", info.get("title"));
        boardService.write(new BoardVO(info.get("title"), info.get("content"),info.get("writer") ,Integer.parseInt(info.get("password"))));
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit/{seq}", method = RequestMethod.GET)
    public String edit(@PathVariable int seq, Model model){
        BoardVO boardVO = boardService.read(seq);
        model.addAttribute("boardVO", boardVO);
        return "/edit";
    }

    @RequestMapping(value = "/edit/{seq}", method = RequestMethod.POST)
    public String edit(@RequestParam HashMap<String, String> info, int pwd, Model model){
        // 정보 검색
        BoardVO boardVO = boardService.read(Integer.parseInt(info.get("seq")));

           if(boardVO.getPassword() == pwd){
               log.info("id: {} ", Integer.parseInt(info.get("seq")));
               boardService.edit(new BoardVO(info.get("title"), info.get("content"), info.get("writer"), Integer.parseInt(info.get("pwd")
                       )), Integer.parseInt(info.get("seq")));
               return "redirect:/list";
           }

           model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
           return "/edit";
    }

    /**
     * 요청을 리디렉션(Redirect) 해서 GET 요청으로 보내는 것을 PRG(POST-Redirect-GET) 패턴 이라고 한다.
     */

    @RequestMapping(value = "/delete/{seq}", method = RequestMethod.GET)
    public String delete(@PathVariable int seq,  Model model){

        log.info(String.valueOf(seq));

        int rowCount;
        BoardVO boardVO = new BoardVO();
        boardVO.setSeq(seq);

        rowCount = boardService.delete(boardVO);

        if(rowCount ==0){
            model.addAttribute("seq", seq);
            model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
        }

        return "redirect:/list";
    }




}
