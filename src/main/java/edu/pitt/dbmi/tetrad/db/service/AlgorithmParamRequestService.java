package edu.pitt.dbmi.tetrad.db.service;

import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.repository.AlgorithmParamRequestRepository;

/**
 * 
 * Oct 26, 2016 4:16:24 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class AlgorithmParamRequestService implements AlgorithmParamRequestRepository {

    private final Session session;
    
    public AlgorithmParamRequestService(final Session session) {
	this.session = session;
    }
    
    @Override
    public void add(AlgorithmParamRequest algorithmParamRequest) {
	session.save(algorithmParamRequest);
    }

    @Override
    public void update(AlgorithmParamRequest algorithmParamRequest) {
	session.saveOrUpdate(algorithmParamRequest);
    }

    @Override
    public void remove(AlgorithmParamRequest algorithmParamRequest) {
	session.delete(algorithmParamRequest);
    }

    @Override
    public AlgorithmParamRequest findById(long id) {
	return session.load(AlgorithmParamRequest.class, id);
    }

}
