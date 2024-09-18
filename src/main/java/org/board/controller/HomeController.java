package org.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class HomeController {

    /**
     * @ResponseBody : 해당 어노테이션으로 인해서 페이지로 연결이 되지 않고 직접 글자가 찍혀져 나왔다.
     *
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Home(){
        return "Home";
    }
}
