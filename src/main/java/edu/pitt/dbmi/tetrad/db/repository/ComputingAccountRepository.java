package edu.pitt.dbmi.tetrad.db.repository;

import java.util.List;

import edu.pitt.dbmi.tetrad.db.entity.ComputingAccount;

/**
 * 
 * Oct 25, 2016 3:01:35 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public interface ComputingAccountRepository {
    
    public void add(ComputingAccount computingAccount);

    public void update(ComputingAccount computingAccount);

    public void remove(ComputingAccount computingAccount);

    public ComputingAccount findByConnectionName(String connectionName);
    
    public ComputingAccount findById(long id);
    
    public List<ComputingAccount> get();
    
}
