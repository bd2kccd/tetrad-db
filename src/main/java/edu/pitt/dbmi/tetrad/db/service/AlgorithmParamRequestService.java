package edu.pitt.dbmi.tetrad.db.service;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.repository.AlgorithmParamRequestRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Transaction transaction = session.beginTransaction();
        session.save(algorithmParamRequest);
        transaction.commit();
    }

    @Override
    public void update(AlgorithmParamRequest algorithmParamRequest) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(algorithmParamRequest);
        transaction.commit();
    }

    @Override
    public void remove(AlgorithmParamRequest algorithmParamRequest) {
        Transaction transaction = session.beginTransaction();
        session.delete(algorithmParamRequest);
        transaction.commit();
    }

    @Override
    public AlgorithmParamRequest findById(long id) {
        return session.load(AlgorithmParamRequest.class, id);
    }

}
