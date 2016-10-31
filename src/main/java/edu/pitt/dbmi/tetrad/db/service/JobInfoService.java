package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.pitt.dbmi.tetrad.db.entity.ComputingAccount;
import edu.pitt.dbmi.tetrad.db.entity.JobInfo;
import edu.pitt.dbmi.tetrad.db.repository.JobInfoRepository;

/**
 * 
 * Oct 26, 2016 4:55:15 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class JobInfoService implements JobInfoRepository {

    private final Session session;
    
    public JobInfoService(final Session session) {
	this.session = session;
    }
    
    @Override
    public void add(JobInfo jobInfo) {
	session.save(jobInfo);
    }

    @Override
    public void update(JobInfo jobInfo) {
	session.saveOrUpdate(jobInfo);
    }

    @Override
    public void remove(JobInfo jobInfo) {
	session.delete(jobInfo);
    }

    @Override
    public JobInfo findById(long id) {
	return session.load(JobInfo.class, id);
    }

    @Override
    public List<JobInfo> findByComputingAccount(
	    ComputingAccount computingAccount) {
	Query query = session.createQuery("FROM jobInfo WHERE computingAccountId = ?");
	query.setLong(0, computingAccount.getId());
	return query.list();
    }

}
