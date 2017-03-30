package edu.pitt.dbmi.tetrad.db.repository;

import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import java.util.List;

/**
 *
 * Oct 25, 2016 3:01:35 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
public interface HpcAccountRepository {

    public void add(HpcAccount hpcAccount);

    public void update(HpcAccount hpcAccount);

    public void remove(HpcAccount hpcAccount);

    public HpcAccount findByConnectionName(String connectionName);

    public HpcAccount findById(long id);

    public List<HpcAccount> get();

}
