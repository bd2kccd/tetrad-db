package edu.pitt.dbmi.tetrad.db.repository;

import java.util.List;

import edu.pitt.dbmi.tetrad.db.entity.ComputingAccount;
import edu.pitt.dbmi.tetrad.db.entity.JobInfo;

/**
 * 
 * Oct 25, 2016 3:10:07 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public interface JobInfoRepository {

    public void add(JobInfo jobInfo);
    
    public void update(JobInfo jobInfo);
    
    public void remove(JobInfo jobInfo);
    
    public JobInfo findById(long id);
    
    public List<JobInfo> findByComputingAccount(ComputingAccount computingAccount);
    
}
