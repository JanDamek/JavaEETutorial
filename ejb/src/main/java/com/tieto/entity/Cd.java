package com.tieto.entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 08/11/2017.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("cd")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cd extends Item {

    private static final long serialVersionUID = 1627572850533939229L;

    private Integer length;

}
