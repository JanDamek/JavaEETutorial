package com.tieto.entity;

import com.tieto.entity.common.EntityWithId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
public class Author implements EntityWithId {

    private static final long serialVersionUID = 3762098544369382345L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Item> books;
}
