package edu.pitt.dbmi.tetrad.db.repository;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;

/**
 * 
 * Oct 26, 2016 2:47:55 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public interface AlgorithmParamRequestRepository {
    
    public void add(AlgorithmParamRequest algorithmParamRequest);
    
    public void update(AlgorithmParamRequest algorithmParamRequest);
    
    public void remove(AlgorithmParamRequest algorithmParamRequest);
    
    public AlgorithmParamRequest findById(long id);
}
