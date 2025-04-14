package com.audible.user.service;

import com.audible.user.dtos.MemberDTO;
import com.audible.user.entity.Member;
import com.audible.user.repository.MemberRepository;
import com.audible.user.utils.MemberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String registerUser(MemberDTO userDto) throws Exception {
        if (memberRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new Exception("User Already Exists");
        }

        Member newMember = MemberUtil.dtoToEntity(userDto);
        newMember.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        memberRepository.save(newMember);
        return "User created Successfully";
    }

    public String loginUser(MemberDTO userDto) throws Exception {
        Member member = memberRepository.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!bCryptPasswordEncoder.matches(userDto.getPassword(), member.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login successful";
    }


}