package com.tts2.subscriberlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts2.subscriberlist.model.Subscriber;
import com.tts2.subscriberlist.repository.SubscriberRepository;

@Controller
public class SubscriberController {
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@GetMapping(value= "/")
	public String index(Subscriber subscriber) {
		return "index.html";
	}
		
		//allows us to post the data to the database
	@PostMapping(value = "/")
	public String addNewSubscriber(Subscriber subscriber, Model model) {
		subscriberRepository.save(new Subscriber(subscriber.getFirstName(), 
	        subscriber.getLastName(), subscriber.getUserName(), subscriber.getSignedUp()));
		model.addAttribute("firstName", subscriber.getFirstName());
		model.addAttribute("lastName", subscriber.getLastName());
		model.addAttribute("userName", subscriber.getUserName());
		return "result.html";
	}
}
