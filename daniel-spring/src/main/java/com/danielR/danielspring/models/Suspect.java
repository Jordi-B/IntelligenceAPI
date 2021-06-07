package com.danielR.danielspring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "suspects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Suspect {
    @Id
    @Column(name = "person_id")
    private String personId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "person_id", referencedColumnName="id")
    private Person person;

    @Column(name = "is_wanted")
    private boolean isWanted;

    @Column(name = "started")
    private Date started;
}
