package com.audible.user.utils;

import com.audible.user.dtos.MemberDTO;
import com.audible.user.entity.Member;

public class MemberUtil {

    public static Member dtoToEntity(MemberDTO memberDTO){
        return new Member(
                memberDTO.getUsername(),
                memberDTO.getEmail(),
                memberDTO.getPassword(),
                memberDTO.getFirstName(),
                memberDTO.getLastName(),
                memberDTO.getAge(),
                memberDTO.getGender(),
                memberDTO.getOrderId(),
                memberDTO.getCartId(),
                memberDTO.getRole()
        );
    }

    public static MemberDTO dtoToEntity(Member member){
        return new MemberDTO(
                member.getUsername(),
                member.getEmail(),
                member.getPassword(),
                member.getFirstName(),
                member.getLastName(),
                member.getAge(),
                member.getGender(),
                member.getOrderId(),
                member.getCartId(),
                member.getRole()
        );
    }
}
