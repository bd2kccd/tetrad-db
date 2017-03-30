package edu.pitt.dbmi.tetrad.db.repository;

import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobInfo;
import java.util.List;

/**
 *
 * Oct 25, 2016 3:10:07 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
public interface HpcJobInfoRepository {

    public void add(HpcJobInfo hpcJobInfo);

    public void update(HpcJobInfo hpcJobInfo);

    public void remove(HpcJobInfo hpcJobInfo);

    public HpcJobInfo findById(long id);

    public List<HpcJobInfo> findByHpcAccount(HpcAccount hpcAccount);

    public List<HpcJobInfo> findByStatus(int status);

}
