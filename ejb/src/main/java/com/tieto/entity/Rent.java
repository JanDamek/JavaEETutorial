package com.tieto.entity;

import com.tieto.entity.common.EntityWithId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rent implements EntityWithId {

    private static final long serialVersionUID = 8916520718309835790L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Item item;

    private Date rentDate;

    private Integer rentFor;
}
