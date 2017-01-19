package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
	this.session = session;
    }
    
    @Override
    public void add(HpcJobLog hpcJobLog) {
	session.save(hpcJobLog);
    }

    @Override
    public void update(HpcJobLog hpcJobLog) {
	session.saveOrUpdate(hpcJobLog);
    }

    @Override
    public void remove(HpcJobLog hpcJobLog) {
	session.delete(hpcJobLog);
    }

    @Override
    public HpcJobLog findById(long id) {
	return session.load(HpcJobLog.class, id);
    }

    @Override
    public List<HpcJobLog> findByHpcJobInfo(HpcJobInfo hpcJobInfo) {
	Query query = session.createQuery("FROM HpcJobLog WHERE hpcJobInfoId = ?");
	query.setLong(0, hpcJobInfo.getId());
	return query.list();
    }

    @Override
    public List<HpcJobLog> findByHpcAccount(HpcAccount hpcAccount) {
	Query query = session.createQuery("FROM HpcJobLog WHERE hpcAccountId = ?");
	query.setLong(0, hpcAccount.getId());
	return query.list();
    }

}
