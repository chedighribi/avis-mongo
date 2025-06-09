package eni.ecole.avis.dal.vin;

import org.springframework.data.mongodb.repository.MongoRepository;

import eni.ecole.avis.bo.vin.Bouteille;
import eni.ecole.avis.bo.vin.BouteilleId;

public interface BouteilleRepository extends MongoRepository<Bouteille, BouteilleId> {
	
}
