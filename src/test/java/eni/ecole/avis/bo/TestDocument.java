package eni.ecole.avis.bo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eni.ecole.avis.dal.AvisRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class TestDocument {
@Autowired
AvisRepository avisRepository;
@Test
void test01_save_avis_sans_commentaire_cours() {
Avis avis = Avis
.builder()
.note(4)
.commentaire("Vin délicieux")
.date(LocalDateTime.now())
.build();
System.out.println(avis);
Avis avisDB = avisRepository.save(avis);
System.out.println("************");
System.out.println(avisDB);

//Vérifier que l'identifiant n'est pas nul
assertThat(avisDB.getId()).isNotNull();
assertThat(avisDB.getId()).isNotBlank();
//Vérifier que tous les attributs sont remplis et non nuls
assertThat(avisDB.getNote()).isNotNull();
assertThat(avisDB.getNote()).isEqualTo(4);
assertThat(avisDB.getCommentaire()).isNotNull();
assertThat(avisDB.getCommentaire()).isNotBlank();
assertThat(avisDB.getDate()).isNotNull();
log.info(avisDB.toString());
}
@Test
void test02_findAll_avis() {
List<Avis> listeAvis = avisRepository.findAll();
assertThat(listeAvis).isNotNull();
assertThat(listeAvis).isNotEmpty();
log.info(listeAvis.toString());
}
}