package com.client_stack_ang.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.client_stack_ang.entity.Client;

@Repository
public class ClientDAOImpl implements ClientDAO {

	// inject hibernate session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Client> getClients() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Client> theQuery = currentSession.createQuery("from Client order by lastName", Client.class);
		
		// execute query and get result list
		List<Client> clients = theQuery.getResultList();
		
		//return the results 
		return clients;
	}

	@Override
	public void saveClient(Client theClient) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the client
		currentSession.saveOrUpdate(theClient);
		
	}

	@Override
	public Client getClient(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve/read from db using the Id
		Client theClient = currentSession.get(Client.class, theId);
		
		return theClient;
	}

	@Override
	public void deleteClient(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with Id
		Query<?> theQuery = currentSession.createQuery("delete from Client where id=:clientId");
		
		theQuery.setParameter("clientId", theId);
		
		theQuery.executeUpdate();
			
	}

	@Override
	public List<Client> searchClients(String theSearchName) {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Client> theQuery = null;
		
		// only search by the name if theSearchName is not empty
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			
			// search for firstName or lastName...case insensitive 
			theQuery = currentSession.createQuery("from Client where lower(firstName) like :theName or lower(lastName) like :theName", Client.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			// the search name is empty, get all clients
			theQuery = currentSession.createQuery("from Client order by lastName", Client.class);
		}
		// execute query and get result list
		List<Client> clients = theQuery.getResultList();
		
		return clients;
	}

	@Override
	public Client showClient(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get the client from the db by their id
		Client theClient = currentSession.get(Client.class, theId);
		
		return theClient;
	}
}
