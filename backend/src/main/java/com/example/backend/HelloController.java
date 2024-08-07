package com.example.backend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    private String message = "Hello";

    @GetMapping
    public String sayHello(){
        return message;
    }

    @PostMapping
    private void changeMessage(@RequestBody String newMessage){
        message = newMessage;
    }
}
