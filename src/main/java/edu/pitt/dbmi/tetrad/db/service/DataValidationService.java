package edu.pitt.dbmi.tetrad.db.service;

import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.DataValidation;
import edu.pitt.dbmi.tetrad.db.repository.DataValidationRepository;

/**
 * 
 * Oct 26, 2016 4:24:27 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class DataValidationService implements DataValidationRepository {

    private final Session session;
    
    public DataValidationService(final Session session) {
	this.session = session;
    }
    
    @Override
    public void add(DataValidation dataValidation) {
	session.save(dataValidation);
    }

    @Override
    public void update(DataValidation dataValidation) {
	session.saveOrUpdate(dataValidation);
    }

    @Override
    public DataValidation findById(long id) {
	return session.load(DataValidation.class, id);
    }

    @Override
    public void remove(DataValidation dataValidation) {
	session.delete(dataValidation);
    }

}
