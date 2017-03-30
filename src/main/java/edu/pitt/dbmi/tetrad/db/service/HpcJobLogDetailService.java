package edu.pitt.dbmi.tetrad.db.service;

import edu.pitt.dbmi.tetrad.db.entity.HpcJobLog;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobLogDetail;
import edu.pitt.dbmi.tetrad.db.repository.HpcJobLogDetailRepository;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * Jan 9, 2017 12:23:52 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
public class HpcJobLogDetailService implements HpcJobLogDetailRepository {

    private final Session session;

    public HpcJobLogDetailService(final Session session) {
        this.session = session;
    }

    @Override
    public void add(HpcJobLogDetail hpcJobLogDetail) {
        Transaction transaction = session.beginTransaction();
        session.save(hpcJobLogDetail);
        transaction.commit();
    }

    @Override
    public void update(HpcJobLogDetail hpcJobLogDetail) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(hpcJobLogDetail);
        transaction.commit();
    }

    @Override
    public void remove(HpcJobLogDetail hpcJobLogDetail) {
        Transaction transaction = session.beginTransaction();
        session.delete(hpcJobLogDetail);
        transaction.commit();
    }

    @Override
    public HpcJobLogDetail findById(long id) {
        return session.load(HpcJobLogDetail.class, id);
    }

    @Override
    public List<HpcJobLogDetail> findByHpcJobLog(HpcJobLog hpcJobLog) {
        Query query = session.createQuery("FROM HpcJobLogDetail WHERE hpcJobLogId = ?");
        query.setLong(0, hpcJobLog.getId());
        return query.list();
    }

}
