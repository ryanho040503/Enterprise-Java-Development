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
 */

package ca.sheridancollege.hohoan.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.hohoan.beans.Phone;
import jakarta.servlet.http.HttpSession;

@Controller
public class PhoneController {
	
//	cart : the cart of customer
//	storeInventory : the inventory of Store
//	cartCount : number of items in cart
	
	List<Phone> cart;
	
	@GetMapping("/")
	public String showHome(Model model,HttpSession session) 
	{
//		Static "store inventory"
		List<Phone> storeInventory = List.of
		(
//			Default phone
			new Phone(1L, "iPhone 15", 1599.99),
	        new Phone(2L, "Samsung Galaxy S24 Ultra", 1499.50),
	        new Phone(3L, "Google Pixel 9 Pro", 1299.00),
	        new Phone(4L, "OnePlus 13", 999.00)
		);
		
//		To let "thymeleaf" know inventory object
		model.addAttribute("inventory", storeInventory);
		
// 		Get cart size to show in header/cart badge
		List<Phone> cart = (List<Phone>) session.getAttribute("phoneList");
		int cartCount = (cart == null) ? 0 : cart.size();
		model.addAttribute("cartCount", cartCount);
		
		return "index";
	}
	
	@GetMapping("/test")
	public String goTest(HttpSession session, Model model) {
		session.setAttribute("sessionID", session.getId());
		if(session.isNew())
			session.setAttribute("myTest", "New Session");
		
		else
			session.setAttribute("myTest", "Welcome Back");
		return "test";
	}
	
	@PostMapping("/insertPhone")
	public String insertPhone(HttpSession session, Model model, @ModelAttribute Phone phone) 
	{
//		Step 1 : Check if the session is new or returned session
		if (session.isNew())
			cart = new ArrayList<Phone>();
		else 
			cart = (ArrayList<Phone>) session.getAttribute("phoneList");
		
//		Step 2 : Add phone to the list from formBinding
		cart.add(phone);
		
//		Step 3 : setAttribute for the session with the "phoneList" to update and save list
		session.setAttribute("phoneList", cart);
		model.addAttribute("phone", new Phone());
		
		return "index";
	}
	
}
