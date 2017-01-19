package edu.pitt.dbmi.tetrad.db.repository;

import java.util.List;

import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobInfo;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobLog;

/**
 * 
 * Jan 6, 2017 3:07:42 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public interface HpcJobLogRepository {

    public void add(HpcJobLog hpcJobLog);
    
    public void update(HpcJobLog hpcJobLog);
    
    public void remove(HpcJobLog hpcJobLog);
 
    public HpcJobLog findById(long id);
    
    public List<HpcJobLog> findByHpcJobInfo(HpcJobInfo hpcJobInfo);
    
    public List<HpcJobLog> findByHpcAccount(HpcAccount hpcAccount);
    
}
