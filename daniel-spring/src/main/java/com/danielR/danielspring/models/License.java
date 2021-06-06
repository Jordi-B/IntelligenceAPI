package com.danielR.danielspring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "licenses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class License {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private String personId;

    @Column(name = "starting_date")
    private Date startingDate;

    @Column(name = "ending_date")
    private Date endingDate;

    @Column(name = "status")
    private int status;

    @Column(name = "license_number")
    private int licenseNumber;
}
