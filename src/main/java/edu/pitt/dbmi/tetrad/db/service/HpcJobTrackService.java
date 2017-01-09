package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobTrack;
import edu.pitt.dbmi.tetrad.db.repository.HpcJobTrackRepository;

/**
 * 
 * Jan 6, 2017 3:56:59 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class HpcJobTrackService implements HpcJobTrackRepository {

    private final Session session;
    
    public HpcJobTrackService(final Session session){
	this.session = session;
    }
    
    @Override
    public void add(HpcJobTrack hpcJobTrack) {
	session.save(hpcJobTrack);
    }

    @Override
    public void update(HpcJobTrack hpcJobTrack) {
	session.saveOrUpdate(hpcJobTrack);
    }

    @Override
    public void remove(HpcJobTrack hpcJobTrack) {
	session.delete(hpcJobTrack);
    }

    @Override
    public HpcJobTrack findById(long id) {
	return session.load(HpcJobTrack.class, id);
    }

    @Override
    public List<HpcJobTrack> findByHpcAccount(HpcAccount hpcAccount) {
	Query query = session.createQuery("FROM hpcJobTrack WHERE hpcAccountId = ?");
	query.setLong(0, hpcAccount.getId());
	return query.list();
    }

}
