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
    @OneToOne(mappedBy = "id")
    @JoinColumn(name = "person_id")
    private String personId;

    @Column(name = "is_wanted")
    private boolean isWanted;

    @Column(name = "started")
    private Date started;
}
