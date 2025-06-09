package eni.ecole.avis.association;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eni.ecole.avis.bo.Avis;
import eni.ecole.avis.bo.Client;
import eni.ecole.avis.dal.AvisRepository;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class TestAssociationAvisClient {
@Autowired
AvisRepository avisRepository;
@Test
void test01_save_avis_stagiaire() {
final Client client = Client
.builder()
.pseudo("bobeponge@email.fr")
.quantiteCommandee(11)
.build();
final Avis avis = Avis
.builder()
.note(4)
.commentaire("Doux. A déguster frais")
.date(LocalDateTime.now())
.build();
//Association
avis.setClient(client);
final Avis avisDB = avisRepository.save(avis);
// Vérifier que l'identifiant n'est pas nul
assertThat(avisDB.getId()).isNotNull();
assertThat(avisDB.getId()).isNotBlank();
// Vérifier que la référence embarquée existe
final Client stagiaireDB = avisDB.getClient();
assertThat(stagiaireDB).isNotNull();
assertThat(stagiaireDB).isEqualTo(client);
log.info(avisDB.toString());
}
}