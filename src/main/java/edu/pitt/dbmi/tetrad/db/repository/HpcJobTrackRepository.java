package edu.pitt.dbmi.tetrad.db.repository;

import java.util.List;

import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobTrack;

/**
 * 
 * Jan 6, 2017 3:07:42 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public interface HpcJobTrackRepository {

    public void add(HpcJobTrack hpcJobTrack);
    
    public void update(HpcJobTrack hpcJobTrack);
    
    public void remove(HpcJobTrack hpcJobTrack);
 
    public HpcJobTrack findById(long id);
    
    public List<HpcJobTrack> findByHpcAccount(HpcAccount hpcAccount);
    
}
