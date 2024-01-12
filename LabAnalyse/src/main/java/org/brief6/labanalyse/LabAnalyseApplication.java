package org.brief6.labanalyse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.brief6.labanalyse.entites.*;
import org.brief6.labanalyse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
@SpringBootApplication
public class LabAnalyseApplication {
	
	
	 @Autowired
	    PatientRepository  patientrepository;
	    @Autowired
	    EchantillonRepository echantillonRepository;
	    @Autowired
	    AnalyseRepository analyseRepository;
	    @Autowired
	    TestRepository testRepository;
	    @Autowired
	    UserRepository userRepository;
	    @Autowired
	    private PlanificationRepository planificationRepository;
	    @Autowired
	    private ReactiveRepository reactiveRepository;

	    public static void main(String[] args) {

	        SpringApplication.run(LabAnalyseApplication.class, args);
	    }
	   @PostConstruct
	   @Transactional
	   public void run() {
	       // Création et sauvegarde d'un Patient
	       Patient patient = new Patient();
	       patient.setName("ahmed samira");
	       patient.setDatenaissnce(new Date());
	       patient.setAdresse("123 rue almajd");
	       patient.setTel("060050500");
	       patientrepository.save(patient);

	       // Création et sauvegarde d'un Echantillon
	       Echantillon echantillon = new Echantillon();
	       echantillon.setPatient(patient);
	       echantillon.setTypeanalyse("bilanSanguine");
	       echantillon.setStatus(StatusEchantillon.PROCESSING);
	       echantillon.setDateprelevement(new Date());
	       echantillonRepository.save(echantillon);

	       // Création et sauvegarde d'une Analyse
	       Analyse analyse = new Analyse();
	       analyse.setEchantillon(echantillon);
	       analyse.setTechnicien("Technicien1");
	       analyse.setDate_debut_analyse(new Date());
	       analyse.setDate_fin_analyse(new Date());
	       analyse.setResultats(StatusResult.ANORMAL);
	       analyseRepository.save(analyse);

	       // Création et sauvegarde d'un test
	       Test test = new Test();
	       test.setName("globalTest");
	       test.setResultattest(30.00);
	       test.setAnalyse(analyse);
	       testRepository.save(test);

	       //Création et sauvegarde d'une Planification
	       Planification planification = new Planification();
	       planification.setDatedebut(new Date());
	       planification.setDatefin(new Date());
	       planification.setAnalyse(analyse);
           analyse.setPlanification(planification);           
	       planificationRepository.save(planification);
	       analyseRepository.save(analyse);

	       //  Création et sauvegarde d'un utilisateur
	       User user = new User();
	       user.setName("Tarek manal");
	       user.setMotpasse("password");
	       user.setInformationpersonelle("information user nawal");
	       user.setPlanification(planification);
	       userRepository.save(user);
	       
	       
	       // Création et sauvegarde d'un  d'un réactif
	       Reactif reactive = new Reactif();
	       reactive.setName("Reactif1");
	       reactive.setDescription("Description");
	       reactive.setDateexperation(new Date());
	       reactive.setQuantitestock(100);
	       reactive.setFournisseur("fournisseur");
	       reactiveRepository.save(reactive);

	       analyse.setReactif(reactive);
	       analyseRepository.save(analyse);


	       // Récupération de toutes les analyses
	           List<Analyse> analyses = analyseRepository.findAll();
	           System.out.println("^______list des analyse____________");
	           for (Analyse a : analyses) {
	               System.out.println("Analyse ID: " + a.getId() + ", Resultat: " + a.getResultats());
	           }


	       }


	

}
