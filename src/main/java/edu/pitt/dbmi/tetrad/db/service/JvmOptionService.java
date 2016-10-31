package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.JvmOption;
import edu.pitt.dbmi.tetrad.db.repository.JvmOptionRepository;

/**
 * 
 * Oct 26, 2016 4:30:49 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class JvmOptionService implements JvmOptionRepository {

    private final Session session;
    
    public JvmOptionService(final Session session) {
	this.session = session;
    }

    @Override
    public void add(JvmOption jvmOptions) {
	session.save(jvmOptions);
    }

    @Override
    public void update(JvmOption jvmOptions) {
	session.saveOrUpdate(jvmOptions);
    }

    @Override
    public void remove(JvmOption jvmOptions) {
	session.delete(jvmOptions);
    }

    @Override
    public JvmOption findById(long id) {
	return session.load(JvmOption.class, id);
    }

    @Override
    public List<JvmOption> findByAlgorithmParamRequest(
	    AlgorithmParamRequest AlgorithmParamRequest) {
	Query query = session.createQuery("FROM JvmOption WHERE algorithmParamRequestId = ?");
	query.setLong(0, AlgorithmParamRequest.getId());
	return query.list();
    }
    
}
