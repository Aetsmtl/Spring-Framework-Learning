package com.aetsmtl.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aetsmtl.model.Account;

@Controller
public class springLearningController {

	private String[] quote = {"To be or not be - Shakespear",
			 "Alors que la pluspart des gens rêvent au succes, les gagnants sont"
			 + " bien reveillés et travaillent dur pour y arriver - Anonyme",
			 "La vie appartient à ceux qui se lèvent tôt",
			 "Le pire n'est pas de tomber mais c'est de ne pas pouvoir se relever"};
	
	@RequestMapping(value = "/getQuote")
	public String getRandomQote(Model model){
		
		int rankQuote = new Random().nextInt(quote.length);
		String randomQuote = quote[rankQuote];
		model.addAttribute("randomQuote", randomQuote);
		return "quote" ;
	}
	
	@RequestMapping(value="/getCreateAccount")
	public String getCreateAccount(@ModelAttribute("aNewAccount") Account account){
		
		System.out.println(account.getFirstName() +"  -  "+ account.getLastName()+ "  -  " +account.getPhoneNumber() );
		return ("createAccount");
	}
}
