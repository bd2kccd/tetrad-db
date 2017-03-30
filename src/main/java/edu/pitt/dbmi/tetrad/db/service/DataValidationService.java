package edu.pitt.dbmi.tetrad.db.service;

import edu.pitt.dbmi.tetrad.db.entity.DataValidation;
import edu.pitt.dbmi.tetrad.db.repository.DataValidationRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Transaction transaction = session.beginTransaction();
        session.save(dataValidation);
        transaction.commit();
    }

    @Override
    public void update(DataValidation dataValidation) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(dataValidation);
        transaction.commit();
    }

    @Override
    public DataValidation findById(long id) {
        return session.load(DataValidation.class, id);
    }

    @Override
    public void remove(DataValidation dataValidation) {
        Transaction transaction = session.beginTransaction();
        session.delete(dataValidation);
        transaction.commit();
    }

}
