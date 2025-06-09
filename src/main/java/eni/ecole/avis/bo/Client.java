package eni.ecole.avis.bo;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Client {
	@Field(name = "login")
	private String pseudo;
	
	@Field(name = "quantity_ordered")
	@EqualsAndHashCode.Exclude
	private int quantiteCommandee;

}
