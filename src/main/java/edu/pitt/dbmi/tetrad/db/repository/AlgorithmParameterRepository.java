package edu.pitt.dbmi.tetrad.db.repository;

import java.util.List;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParameter;

/**
 * 
 * Oct 26, 2016 2:41:43 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public interface AlgorithmParameterRepository {
    
    public void add(AlgorithmParameter algorithmParameters);
    
    public void update(AlgorithmParameter algorithmParameters);
    
    public void remove(AlgorithmParameter algorithmParameters);
    
    public AlgorithmParameter findById(long id);
    
    public List<AlgorithmParameter> findByalgorithmParamRequest(AlgorithmParamRequest algorithmParamRequest);
    
}
