package com.tieto.entity;

import com.tieto.domain.RoleEnum;
import com.tieto.entity.common.EntityWithId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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