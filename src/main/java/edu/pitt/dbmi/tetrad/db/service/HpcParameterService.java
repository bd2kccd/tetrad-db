/*
 * Copyright (C) 2015 University of Pittsburgh.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.HpcParameter;
import edu.pitt.dbmi.tetrad.db.repository.HpcParameterRepository;

/**
 * 
 * Mar 14, 2017 7:26:01 PM
 * 
 * @author Chirayu Kong Wongchokprasitti, PhD (chw20@pitt.edu)
 *
 */
public class HpcParameterService implements HpcParameterRepository {

	private final Session session;
	
	public HpcParameterService(final Session session) {
		this.session = session;
	}
	
	@Override
	public void add(HpcParameter hpcParameter) {
		Transaction transaction = session.beginTransaction();
		session.save(hpcParameter);
		transaction.commit();
	}

	@Override
	public void update(HpcParameter hpcParameter) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(hpcParameter);
		transaction.commit();
	}

	@Override
	public void remove(HpcParameter hpcParameter) {
		Transaction transaction = session.beginTransaction();
		session.delete(hpcParameter);
		transaction.commit();
	}

	@Override
	public HpcParameter findById(long id) {
		return session.load(HpcParameter.class, id);
	}

	@Override
	public List<HpcParameter> findByAlgorithmParamRequest(AlgorithmParamRequest AlgorithmParamRequest) {
		Query query = session.createQuery("FROM HpcParameter WHERE algorithmParamRequestId = ?");
		query.setLong(0, AlgorithmParamRequest.getId());
		return query.list();
	}

}
