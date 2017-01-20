package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobInfo;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobLog;
import edu.pitt.dbmi.tetrad.db.repository.HpcJobLogRepository;

/**
 * 
 * Jan 6, 2017 3:56:59 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class HpcJobLogService implements HpcJobLogRepository {

    private final Session session;
    
    public HpcJobLogService(final Session session){
	Transaction transaction = session.beginTransaction();
	this.session = session;
	transaction.commit();
    }
    
    @Override
    public void add(HpcJobLog hpcJobLog) {
	Transaction transaction = session.beginTransaction();
	session.save(hpcJobLog);
	transaction.commit();
    }

    @Override
    public void update(HpcJobLog hpcJobLog) {
	Transaction transaction = session.beginTransaction();
	session.saveOrUpdate(hpcJobLog);
	transaction.commit();
    }

    @Override
    public void remove(HpcJobLog hpcJobLog) {
	Transaction transaction = session.beginTransaction();
	session.delete(hpcJobLog);
	transaction.commit();
    }

    @Override
    public HpcJobLog findById(long id) {
	return session.load(HpcJobLog.class, id);
    }

    @Override
    public HpcJobLog findByHpcJobInfo(HpcJobInfo hpcJobInfo) {
	Query query = session.createQuery("FROM HpcJobLog WHERE hpcJobInfoId = ?");
	query.setLong(0, hpcJobInfo.getId());
	List result = query.list();
	if(result.isEmpty())return null;
	return (HpcJobLog)query.list().get(0);
    }

    @Override
    public List<HpcJobLog> findByHpcAccount(HpcAccount hpcAccount) {
	Query query = session.createQuery("FROM HpcJobLog WHERE hpcAccountId = ?");
	query.setLong(0, hpcAccount.getId());
	return query.list();
    }

}
