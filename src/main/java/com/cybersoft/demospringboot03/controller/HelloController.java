package com.cybersoft.demospringboot03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController (@Controller + @ResponseBody): dùng để định nghĩa đường dẫn
 *                 và trả ra dữ liệu dưới dạng
 *                 json
 * @ResponseBody: giúp cho @Controller trả ra dữ liệu dưới dạng json
 *                HelloController
 * @Controller: dùng để định nghĩa đường dẫn, trả ra html
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public String hello() {
        return "Hello Spring Booooooooot";
    }

    @GetMapping("/cybersoft")
    public String cybersoft() {
        return "Cybersoft";
    }

}
