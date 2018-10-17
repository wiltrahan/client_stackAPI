package com.client_stack_ang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.client_stack_ang.dao.ClientDAO;
import com.client_stack_ang.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	// inject the client dao
	@Autowired
	private ClientDAO clientDAO;
	
	
	@Override
	@Transactional
	public List<Client> getClients() {
		return clientDAO.getClients();
	}


	@Override
	@Transactional
	public void saveClient(Client theClient) {
		clientDAO.saveClient(theClient);
	}


	@Override
	@Transactional
	public Client getClient(int theId) {
		return clientDAO.getClient(theId);
	}


	@Override
	@Transactional
	public void deleteClient(int theId) {
		clientDAO.deleteClient(theId);
	}


	@Override
	@Transactional
	public List<Client> searchClients(String theSearchName) {
		return clientDAO.searchClients(theSearchName);
	}


	@Override
	@Transactional
	public Client showClient(int theId) {
		return clientDAO.showClient(theId);
	}

}
