package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.ComputingAccount;
import edu.pitt.dbmi.tetrad.db.repository.ComputingAccountRepository;

/**
 * 
 * Oct 26, 2016 12:22:49 AM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class ComputingAccountService implements ComputingAccountRepository {

    private final Session session;
    
    public ComputingAccountService(final Session session) {
	this.session = session;
    }
    
    @Override
    public void add(ComputingAccount computingAccount) {
	session.save(computingAccount);
    }

    @Override
    public void update(ComputingAccount computingAccount) {
	session.saveOrUpdate(computingAccount);
    }

    @Override
    public void remove(ComputingAccount computingAccount) {
	session.delete(computingAccount);
    }

    @Override
    public ComputingAccount findByConnectionName(String connectionName) {
	Query query = session.createQuery("FROM ComputingAccount WHERE connectionName = ?");
	query.setString(0, connectionName);
	List result = query.list();
	if(result.isEmpty())return null;
	return (ComputingAccount)query.list().get(0);
    }

    @Override
    public ComputingAccount findById(long id) {
	return session.load(ComputingAccount.class, id);
    }

    @Override
    public List<ComputingAccount> get() {
	Query query = session.createQuery("FROM ComputingAccount");
	return query.list();
    }

}
