package eni.ecole.avis.bo.vin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import eni.ecole.avis.bo.Avis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(collection = "bottles")
public class Bouteille {
	@Id
	private BouteilleId id;
	
	@Field(name ="name")
	private String nom;

}
