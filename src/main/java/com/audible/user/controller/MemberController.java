package com.audible.user.controller;

import com.audible.user.dtos.MemberDTO;
import com.audible.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody MemberDTO userDto){

        try{
          String output = memberService.registerUser(userDto);
          return ResponseEntity.status(HttpStatus.CREATED).body(output);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody MemberDTO userDto){
        try{
            String output = memberService.loginUser(userDto);
            return ResponseEntity.status(HttpStatus.OK).body(output);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
