package edu.pitt.dbmi.tetrad.db.service;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.JvmOption;
import edu.pitt.dbmi.tetrad.db.repository.JvmOptionRepository;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public void add(JvmOption jvmOption) {
        Transaction transaction = session.beginTransaction();
        session.save(jvmOption);
        transaction.commit();
    }

    @Override
    public void update(JvmOption jvmOption) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(jvmOption);
        transaction.commit();
    }

    @Override
    public void remove(JvmOption jvmOption) {
        Transaction transaction = session.beginTransaction();
        session.delete(jvmOption);
        transaction.commit();
    }

    @Override
    public JvmOption findById(long id) {
        return session.load(JvmOption.class, id);
    }

    @Override
    public List<JvmOption> findByAlgorithmParamRequest(AlgorithmParamRequest AlgorithmParamRequest) {
        Query query = session.createQuery("FROM JvmOption WHERE algorithmParamRequestId = ?");
        query.setLong(0, AlgorithmParamRequest.getId());
        return query.list();
    }

}
