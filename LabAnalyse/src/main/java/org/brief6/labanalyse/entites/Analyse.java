package org.brief6.labanalyse.entites;

import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "analyses")

public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Echantillon echantillon;
    private String Technicien;
    private Date date_debut_analyse;
    private Date date_fin_analyse;
    @Enumerated(EnumType.STRING)
    private StatusResult resultats;
    @OneToMany (mappedBy="analyse",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
     private List<Test> listtest;
    @ManyToOne
    private Reactif reactif;
    @OneToOne
    private Planification planification;
}
