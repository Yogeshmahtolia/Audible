package com.audible.user.dtos;

import com.audible.user.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private Long orderId;
    private Long cartId;
    private Role role;
}
