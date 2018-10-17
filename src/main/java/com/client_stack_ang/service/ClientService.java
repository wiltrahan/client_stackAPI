package com.client_stack_ang.service;

import java.util.List;

import com.client_stack_ang.entity.Client;

public interface ClientService {

	public List<Client> getClients();

	public void saveClient(Client theClient);

	public Client getClient(int theId);

	public void deleteClient(int theId);

	public List<Client> searchClients(String theSearchName);
	
	public Client showClient(int theId);
	
}
