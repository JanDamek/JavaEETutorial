package com.tieto.entity;

import com.tieto.entity.common.EntityWithId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
public class Place implements EntityWithId {

    private static final long serialVersionUID = 9066270585499061703L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "whereItemAre")
    private String where;

    private boolean free;

    @ManyToOne
    private Item placeFor;
}
