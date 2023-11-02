package com.example.demospringboot03.controller;

import com.example.demospringboot03.payload.request.LoginRequest;
import com.example.demospringboot03.payload.request.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Controller: Dùng để định nghĩa đường dẫn mà nội dung đường dẫn trả ra html
 * @ResponseBody: giúp cho annotation @Controller có thể trả ra kiểu String dùng để viết API
 *
 * @RestController: là sự kết hợp của @Controller và @ResponseBody => Viết API
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    //Tham số truyền trên trình duyệt: @RequestParam
    //Tham số truyền ngầm: @RequestParam
    //Tham số đóng vai trò như là một đường dẫn: @PathVariable
    //Tham số là đối tượng: @RequestBody



    @GetMapping("")
    public String hello(@RequestParam String hoten, @RequestParam int tuoi){
        return "Hello Spring boot " + hoten + " - tuoi: " + tuoi;
    }
    @PostMapping ("/cybersoft")
    public String helloCybersoft(@RequestParam LoginRequest loginRequest){
        //form-data: có hỗ trợ cho phép truyền file lên
        // x-www-form-urlen: ko có hỗ trợ cho phép truyền file
        // raw: cho phép truyền đối tượng

        return "Hello Spring Cybersoft " + loginRequest.getUsername() + " - " + loginRequest.getPassword();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id){
        return new ResponseEntity<>("update " + id, HttpStatus.OK);
    }

}
