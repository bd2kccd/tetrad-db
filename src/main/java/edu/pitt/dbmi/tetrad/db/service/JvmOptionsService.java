package edu.pitt.dbmi.tetrad.db.service;

import edu.pitt.dbmi.tetrad.db.entity.JvmOptions;
import edu.pitt.dbmi.tetrad.db.repository.JvmOptionsRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * Oct 26, 2016 4:30:49 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
public class JvmOptionsService implements JvmOptionsRepository {

    private final Session session;

    public JvmOptionsService(final Session session) {
        this.session = session;
    }

    @Override
    public void add(JvmOptions jvmOptions) {
        Transaction transaction = session.beginTransaction();
        session.save(jvmOptions);
        transaction.commit();
    }

    @Override
    public void update(JvmOptions jvmOptions) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(jvmOptions);
        transaction.commit();
    }

    @Override
    public void remove(JvmOptions jvmOptions) {
        Transaction transaction = session.beginTransaction();
        session.delete(jvmOptions);
        transaction.commit();
    }

    @Override
    public JvmOptions findById(long id) {
        return session.load(JvmOptions.class, id);
    }

}
