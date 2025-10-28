package ca.sheridancollege.hohoan.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements Serializable {
	
//	Unique ID of the phone.
	private Long id;
	
//	Human-readable model name of the phone
	private String model;
	
//	Price of the phone in dollars
	private double price;
	
}
