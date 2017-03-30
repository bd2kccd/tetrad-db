package edu.pitt.dbmi.tetrad.db.repository;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.JvmOption;
import java.util.List;

/**
 *
 * Oct 26, 2016 2:56:03 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
public interface JvmOptionRepository {

    public void add(JvmOption jvmOptions);

    public void update(JvmOption jvmOptions);

    public void remove(JvmOption jvmOptions);

    public JvmOption findById(long id);

    public List<JvmOption> findByAlgorithmParamRequest(AlgorithmParamRequest AlgorithmParamRequest);

}
