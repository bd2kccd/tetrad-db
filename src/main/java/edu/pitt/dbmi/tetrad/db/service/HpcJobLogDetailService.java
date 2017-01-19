package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.HpcJobLog;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobLogDetail;
import edu.pitt.dbmi.tetrad.db.repository.HpcJobLogDetailRepository;

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
	session.save(hpcJobLogDetail);
    }

    @Override
    public void update(HpcJobLogDetail hpcJobLogDetail) {
	session.saveOrUpdate(hpcJobLogDetail);
    }

    @Override
    public void remove(HpcJobLogDetail hpcJobLogDetail) {
	session.delete(hpcJobLogDetail);
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
