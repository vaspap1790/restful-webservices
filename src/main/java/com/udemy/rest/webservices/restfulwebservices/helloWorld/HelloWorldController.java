package com.udemy.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world/{name}")
    public String helloWord(@PathVariable String name){
        return "Hello World " + name;
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWordInternationalized(){
        return messageSource.getMessage("good.morning.message", null, "Default Message", LocaleContextHolder.getLocale());
    }
}
