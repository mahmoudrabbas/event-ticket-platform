package com.event_ticket.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi")
public class HomeController {
    @GetMapping("/hi")
    public String print(){
        return "Hello";
    }
}
