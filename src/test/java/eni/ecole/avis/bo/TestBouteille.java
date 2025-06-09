package eni.ecole.avis.bo;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eni.ecole.avis.bo.vin.Bouteille;
import eni.ecole.avis.bo.vin.BouteilleId;
import eni.ecole.avis.dal.vin.BouteilleRepository;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class TestBouteille {
@Autowired
BouteilleRepository bouteilleRepository;
@Test
void test_save_bouteille() {
BouteilleId bouteilleId = BouteilleId
.builder()
.idBouteille(2298)
.idRegion(5)
.idCouleur(1)
.build();
Bouteille bouteille = Bouteille
.builder()
.id(bouteilleId)
.nom("Vin Blanc ENI")
.build();
System.out.println(bouteille);
bouteilleRepository.save(bouteille);
//Vérification en base
Optional<Bouteille> opt = bouteilleRepository.findById(bouteilleId);
assertThat(opt).isNotNull();
assertThat(opt.isPresent()).isTrue();
Bouteille bouteilleDB = opt.get();
assertThat(bouteilleDB).isNotNull();
assertThat(bouteilleDB.getNom()).isNotNull();
log.info(bouteilleDB.toString());
}
}