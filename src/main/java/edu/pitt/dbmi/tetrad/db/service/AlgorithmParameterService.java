package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParameter;
import edu.pitt.dbmi.tetrad.db.repository.AlgorithmParameterRepository;

/**
 * 
 * Oct 26, 2016 3:06:36 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class AlgorithmParameterService implements
	AlgorithmParameterRepository {

    private final Session session;
    
    public AlgorithmParameterService(final Session session) {
	this.session = session;
    }
    
    @Override
    public void add(AlgorithmParameter algorithmParameters) {
	Transaction transaction = session.beginTransaction();
	session.save(algorithmParameters);
	transaction.commit();
    }

    @Override
    public void update(AlgorithmParameter algorithmParameters) {
	Transaction transaction = session.beginTransaction();
	session.saveOrUpdate(algorithmParameters);
	transaction.commit();
    }

    @Override
    public void remove(AlgorithmParameter algorithmParameters) {
	Transaction transaction = session.beginTransaction();
	session.delete(algorithmParameters);
	transaction.commit();
    }

    @Override
    public AlgorithmParameter findById(long id) {
	return session.load(AlgorithmParameter.class, id);
    }

    @Override
    public List<AlgorithmParameter> findByalgorithmParamRequest(
	    AlgorithmParamRequest algorithmParamRequest) {
	Query query = session.createQuery("FROM AlgorithmParameters WHERE algorithmParamRequestId = ?");
	query.setLong(0, algorithmParamRequest.getId());
	return query.list();
    }

}
