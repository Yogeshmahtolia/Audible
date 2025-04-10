package com.audible.user.entity;

import com.audible.user.enums.Genre;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_favourite")
@Data
public class MemberGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private Genre genre;

}
