package eni.ecole.avis.dal;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvisRepository extends MongoRepository<eni.ecole.avis.bo.Avis, String>{
}