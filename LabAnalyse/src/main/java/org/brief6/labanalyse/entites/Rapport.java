package org.brief6.labanalyse.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "rapportstatistique")
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tayperapport;
    private Date daterapport;
    private String donneestatistique;

}
