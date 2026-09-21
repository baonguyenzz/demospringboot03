package com.cybersoft.demospringboot03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybersoft.demospringboot03.entity.Student;
import com.cybersoft.demospringboot03.entity.UsersEntity;
import com.cybersoft.demospringboot03.payload.request.LoginRequest;
import com.cybersoft.demospringboot03.repository.UsersRepository;

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

    /**
     * Tham số truyền trên trình duyệt: Request Param
     * Tham số truyền ngầm: Request Param
     * Tham số đóng vai trò như một đường dẫn: Path Variable
     * Tham số là một đối tượng: Request Body
     * 
     * @return
     */

    @Autowired
    private Student student; // IOC

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("")

    /**
     * lỗi 400: Bad Request: tham số truyền không hợp lệ -> 1. thiếu tham số, 2. sai
     * kiểu dữ liệu tham số, 3. sai tên tham số
     * 
     * @param name
     * @return
     */
    public ResponseEntity<?> hello() {
        // List<UsersEntity> list = usersRepository.findAll();
        UsersEntity user = usersRepository.findByEmail("tranvanc@gmail.com");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/cybersoft")

    /**
     * tham số truyền ngầm trên postman:
     * 1. form-data: tham số truyền ngầm cho phép truyền file
     * 2. x-www-form-urlencoded: tham số truyền ngầm không cho phép truyền file
     * 3. raw: tham số truyền ngầm cho phép truyền lên một đối tượng
     * 
     * @param job
     * @return
     */
    public String cybersoft(@RequestBody LoginRequest loginRequest) {
        return "Cybersoft " + loginRequest.getUsername() + " - password: " + loginRequest.getPassword();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id) {
        return new ResponseEntity<>("Update success " + id, HttpStatus.OK);
    }

}
