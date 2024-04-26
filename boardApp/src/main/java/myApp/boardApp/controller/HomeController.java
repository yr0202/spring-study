package myApp.boardApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // = @Controller + @ResponseBody
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String signUp(){
        return "test!";
    }
}
