package edu.pitt.dbmi.tetrad.db.repository;

import edu.pitt.dbmi.tetrad.db.entity.DataValidation;

/**
 *
 * Oct 26, 2016 2:54:00 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
public interface DataValidationRepository {

    public void add(DataValidation dataValidation);

    public void update(DataValidation dataValidation);

    public void remove(DataValidation dataValidation);

    public DataValidation findById(long id);
}
