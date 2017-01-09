package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.HpcJobTrack;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobTrackState;
import edu.pitt.dbmi.tetrad.db.repository.HpcJobTrackStateRepository;

/**
 * 
 * Jan 9, 2017 12:23:52 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class HpcJobTrackStateService implements HpcJobTrackStateRepository {

    private final Session session;
    
    public HpcJobTrackStateService(final Session session) {
	this.session = session;
    }
    
    @Override
    public void add(HpcJobTrackState hpcJobTrackState) {
	session.save(hpcJobTrackState);
    }

    @Override
    public void update(HpcJobTrackState hpcJobTrackState) {
	session.saveOrUpdate(hpcJobTrackState);
    }

    @Override
    public void remove(HpcJobTrackState hpcJobTrackState) {
	session.delete(hpcJobTrackState);
    }

    @Override
    public HpcJobTrackState findById(long id) {
	return session.load(HpcJobTrackState.class, id);
    }

    @Override
    public List<HpcJobTrackState> findByHpcJobTrack(HpcJobTrack hpcJobTrack) {
	Query query = session.createQuery("FROM hpcJobTrackState WHERE hpcJobTrackId = ?");
	query.setLong(0, hpcJobTrack.getId());
	return query.list();
    }

}
