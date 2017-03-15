package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.repository.HpcAccountRepository;

/**
 * 
 * Oct 26, 2016 12:22:49 AM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class HpcAccountService implements HpcAccountRepository {

	private final Session session;

	public HpcAccountService(final Session session) {
		this.session = session;
	}

	@Override
	public void add(HpcAccount hpcAccount) {
		Transaction transaction = session.beginTransaction();
		session.save(hpcAccount);
		transaction.commit();
	}

	@Override
	public void update(HpcAccount hpcAccount) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(hpcAccount);
		transaction.commit();
	}

	@Override
	public void remove(HpcAccount hpcAccount) {
		Transaction transaction = session.beginTransaction();
		session.delete(hpcAccount);
		transaction.commit();
	}

	@Override
	public HpcAccount findByConnectionName(String connectionName) {
		Query query = session.createQuery("FROM HpcAccount WHERE connectionName = ?");
		query.setString(0, connectionName);
		List result = query.list();
		if (result.isEmpty())
			return null;
		return (HpcAccount) query.list().get(0);
	}

	@Override
	public HpcAccount findById(long id) {
		return session.load(HpcAccount.class, id);
	}

	@Override
	public List<HpcAccount> get() {
		Query query = session.createQuery("FROM HpcAccount");
		return query.list();
	}

}
