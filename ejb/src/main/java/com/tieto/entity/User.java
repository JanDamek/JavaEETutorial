package com.tieto.entity;

import com.tieto.domain.RoleEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User implements EntityWithId {

    private static final long serialVersionUID = 649205710537401333L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    private String password;

    @OneToOne
    private Client client;

    private RoleEnum role;

}