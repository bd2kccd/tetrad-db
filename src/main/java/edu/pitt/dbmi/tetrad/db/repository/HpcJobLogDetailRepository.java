package edu.pitt.dbmi.tetrad.db.repository;

import edu.pitt.dbmi.tetrad.db.entity.HpcJobLog;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobLogDetail;
import java.util.List;

/**
 *
 * Jan 6, 2017 3:20:20 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
public interface HpcJobLogDetailRepository {

    public void add(HpcJobLogDetail hpcJobLogDetail);

    public void update(HpcJobLogDetail hpcJobLogDetail);

    public void remove(HpcJobLogDetail hpcJobLogDetail);

    public HpcJobLogDetail findById(long id);

    public List<HpcJobLogDetail> findByHpcJobLog(HpcJobLog hpcJobLog);

}
