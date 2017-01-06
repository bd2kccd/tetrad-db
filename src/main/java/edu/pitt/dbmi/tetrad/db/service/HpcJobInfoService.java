package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobInfo;
import edu.pitt.dbmi.tetrad.db.repository.HpcJobInfoRepository;

/**
 * 
 * Oct 26, 2016 4:55:15 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class HpcJobInfoService implements HpcJobInfoRepository {

    private final Session session;
    
    public HpcJobInfoService(final Session session) {
	this.session = session;
    }
    
    @Override
    public void add(HpcJobInfo hpcJobInfo) {
	session.save(hpcJobInfo);
    }

    @Override
    public void update(HpcJobInfo hpcJobInfo) {
	session.saveOrUpdate(hpcJobInfo);
    }

    @Override
    public void remove(HpcJobInfo hpcJobInfo) {
	session.delete(hpcJobInfo);
    }

    @Override
    public HpcJobInfo findById(long id) {
	return session.load(HpcJobInfo.class, id);
    }

    @Override
    public List<HpcJobInfo> findByHpcAccount(
	    HpcAccount hpcAccount) {
	Query query = session.createQuery("FROM hpcJobInfo WHERE hpcAccountId = ?");
	query.setLong(0, hpcAccount.getId());
	return query.list();
    }

}
