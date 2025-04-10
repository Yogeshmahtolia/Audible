package com.audible.user.service;

import com.audible.user.dtos.MemberDTO;
import com.audible.user.entity.Member;
import com.audible.user.repository.MemberRepository;
import com.audible.user.utils.MemberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public String registerUser(MemberDTO userDto) throws Exception {
        if(memberRepository.findByUsername(userDto.getUsername()).isPresent()){
            throw new Exception("User Already Exists");
        }

        Member newMember = MemberUtil.dtoToEntity(userDto);
        memberRepository.save(newMember);
        return "User created Successfully";
    }
}
