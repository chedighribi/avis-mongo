package eni.ecole.avis.bo;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import eni.ecole.avis.bo.vin.Bouteille;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(collection = "review")
public class Avis {
	@Id
	private String id;
	
	private int note;
	
	@Field(name = "commentary")
	private String commentaire;
	
	private LocalDateTime date;
	
	private Client client;
	
	@DBRef
	@Field("bottle_id")
	private Bouteille bouteille;
	
}
