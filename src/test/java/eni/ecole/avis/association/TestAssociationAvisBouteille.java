package eni.ecole.avis.association;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eni.ecole.avis.bo.Avis;
import eni.ecole.avis.bo.Client;
import eni.ecole.avis.bo.vin.Bouteille;
import eni.ecole.avis.dal.AvisRepository;
import eni.ecole.avis.dal.vin.BouteilleRepository;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestAssociationAvisBouteille {

	@Autowired
	AvisRepository avisRepository;
	@Autowired
	BouteilleRepository bouteilleRepository;
	@Test
	void test01_save_avis_formateur() {
	// Récupération des Bouteille en base
	final List<Bouteille> listeBouteilleDB = bouteilleRepository.findAll();
	assertThat(listeBouteilleDB).isNotNull();
	assertThat(listeBouteilleDB).isNotEmpty();
	final Bouteille bouteilleDB = listeBouteilleDB.get(0);
	final Client client = Client
	.builder()
	.pseudo("bobeponge@email.fr")
	.quantiteCommandee(11)
	.build();
	final Avis avis = Avis
	.builder()
	.note(5)
	.commentaire("Doux. A déguster frais")
	.client(client)
	.build();
	// Association avec Bouteille
	avis.setBouteille(bouteilleDB);
	// Sauver
	final Avis avisDB = avisRepository.save(avis);
	// Vérifier que l'identifiant n'est pas nul
	assertThat(avisDB.getId()).isNotNull();
	assertThat(avisDB.getId()).isNotBlank();
	// Vérifier que le Client n'est pas nul
	assertThat(avisDB.getClient()).isNotNull();
	assertThat(avisDB.getClient()).isEqualTo(client);
	// Vérifier que le Bouteille est complet
	assertThat(avisDB.getBouteille().getId()).isNotNull();
	assertThat(avisDB.getBouteille()).isEqualTo(bouteilleDB);
	log.info(avisDB.toString());
	}
}
