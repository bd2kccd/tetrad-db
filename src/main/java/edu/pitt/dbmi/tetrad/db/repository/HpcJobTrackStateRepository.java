package edu.pitt.dbmi.tetrad.db.repository;

import java.util.List;

import edu.pitt.dbmi.tetrad.db.entity.HpcJobTrack;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobTrackState;

/**
 * 
 * Jan 6, 2017 3:20:20 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public interface HpcJobTrackStateRepository {
    
    public void add(HpcJobTrackState hpcJobTrackState);
    
    public void update(HpcJobTrackState hpcJobTrackState);

    public void remove(HpcJobTrackState hpcJobTrackState);
    
    public HpcJobTrackState findById(long id);
    
    public List<HpcJobTrackState> findByHpcJobTrack(HpcJobTrack hpcJobTrack);
    
}
