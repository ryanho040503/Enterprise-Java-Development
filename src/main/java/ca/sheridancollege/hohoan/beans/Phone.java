/*
	Author Name: Ho Hoang Duy     
	Student ID: 991794661
	Email Student : ryanho040503@gmail.com (Personal Email)
	Date: Oct 28 2025 (Week 8)
	Application Description : This small web application help user to add desired phone(s) to cart and then purchase those
	Semester : 3nd
	Course : Enterprise Java Development
	Instructor : Pooja Kakkar
	Email Instructor : kakkarpo@sheridan.desire2learn.com
	Github : https://github.com/ryanho040503/Enterprise-Java-Development
 */

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
