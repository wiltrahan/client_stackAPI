package com.client_stack_ang.rest;

//import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client_stack_ang.entity.Client;
import com.client_stack_ang.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientRestController {
	
	// inject the client service
	@Autowired
	private ClientService clientService;
	
	// define end point for /clients
	@GetMapping("/clients")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Client> getClients() {
		return clientService.getClients();
	}
	
	// define end point for "/clients/{clientId}
	@GetMapping("/clients/{clientId}") 
	public Client getClient(@PathVariable int clientId) {
		
		Client theClient = clientService.getClient(clientId);
		
		if(theClient == null) {
			throw new ClientNotFoundException("Client id not found " + clientId);
		}
		
		return theClient;

	}	
	
	//mapping for POST /clients -- add new client
	@PostMapping("/clients")
	public Client addClient(@RequestBody Client theClient) {
		
		//just in case they pass an id as json, set to 0
		//this will force save the new client instead of update
		theClient.setId(0);

		clientService.saveClient(theClient);
		
		return theClient;
	}
	
	@PutMapping("/clients")
	public Client updateClient(@RequestBody Client theClient) {
		
		clientService.saveClient(theClient);
		
		return theClient;
	}
	
	@DeleteMapping("/clients/{clientId}")
	public String deleteClient(@PathVariable int clientId) {
		
		Client tempClient = clientService.getClient(clientId);
		if(tempClient == null) {
			throw new ClientNotFoundException("Client id not found - " + clientId);
		}
		
		clientService.deleteClient(clientId);
		
		return "Deleted customer id - " + clientId;
	}
	
}
