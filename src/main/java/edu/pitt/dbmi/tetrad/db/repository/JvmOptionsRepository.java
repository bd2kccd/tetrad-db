package edu.pitt.dbmi.tetrad.db.repository;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.JvmOptions;

/**
 *
 * Oct 26, 2016 2:56:03 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
public interface JvmOptionsRepository {

    public void add(JvmOptions jvmOptions);

    public void update(JvmOptions jvmOptions);

    public void remove(JvmOptions jvmOptions);

    public JvmOptions findById(long id);

}
