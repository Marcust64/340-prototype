package com.pickandgo.demo.OtherControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllController {



    @GetMapping("/searchresults")
    public String showResults(){
        return "searchresults";
    }
    
    
}
