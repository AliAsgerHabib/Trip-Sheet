//package org.ashara.chennai.transport.tripsheet.controllers;
//
//import org.ashara.chennai.transport.tripsheet.beans.LoginCredentials;
//import org.ashara.chennai.transport.tripsheet.beans.NewUserBean;
//import org.ashara.chennai.transport.tripsheet.beans.UserBean;
////import org.ashara.chennai.transport.tripsheet.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/user")
//public class LoginController {
//
//    @Autowired
//    UserService userService;
//
//    @PostMapping("/login")
//    ResponseEntity<UserBean> loginUser(@RequestBody LoginCredentials loginCredentials) {
//        UserBean user = userService.loginUser(loginCredentials);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    ResponseEntity<String> addUser(@RequestBody NewUserBean newUserBean) {
//        String status = userService.addUser(newUserBean);
//        return new ResponseEntity<>(status, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/hello")
//    ResponseEntity<String> greet() {
//        return new ResponseEntity<>("Hello World", HttpStatus.OK);
//    }
//
//
//}
