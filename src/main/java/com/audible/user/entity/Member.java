package com.audible.user.entity;

import com.audible.user.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member{

    @Id
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private Long orderId;
    private Long cartId;
    @Enumerated(EnumType.STRING)
    private Role role;

}
