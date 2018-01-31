package edu.pitt.dbmi.tetrad.db.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParameter;
import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobInfo;
import edu.pitt.dbmi.tetrad.db.entity.HpcParameter;
import edu.pitt.dbmi.tetrad.db.entity.JvmOptions;
import edu.pitt.dbmi.tetrad.db.repository.HpcJobInfoRepository;

/**
 *
 * Oct 26, 2016 4:55:15 PM
 *
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 *
 */
public class HpcJobInfoService implements HpcJobInfoRepository {

    private final Session session;

    public HpcJobInfoService(final Session session) {
        this.session = session;
    }

    @Override
    public void add(HpcJobInfo hpcJobInfo) {
        Transaction transaction = session.beginTransaction();
        AlgorithmParamRequest algorithmParamRequest = hpcJobInfo.getAlgorithmParamRequest();
        Set<AlgorithmParameter> algorithmParameters = algorithmParamRequest.getAlgorithmParameters();
        for (AlgorithmParameter algorithmParameter : algorithmParameters) {
            System.out.println("HpcJobInfoService: add: AlgorithmParameter: " + algorithmParameter.getParameter() + ":"
                    + algorithmParameter.getValue());
            session.save(algorithmParameter);
        }
        JvmOptions jvmOptions = algorithmParamRequest.getJvmOptions();
        if(jvmOptions != null){
            System.out.println(
                    "HpcJobInfoService: add: JvmOptions: maxHeapSize: " + jvmOptions.getMaxHeapSize());
        	session.save(jvmOptions);
        }
        Set<HpcParameter> hpcParameters = algorithmParamRequest.getHpcParameters();
        if (hpcParameters != null) {
            for (HpcParameter param : hpcParameters) {
                System.out.println("HpcJobInfoService: add: HpcParameter: " + param.getKey() + ":" + param.getValue());
                session.save(param);
            }
        }
        session.save(algorithmParamRequest);
        session.save(hpcJobInfo);
        transaction.commit();
    }

    @Override
    public void update(HpcJobInfo hpcJobInfo) {
        Transaction transaction = session.beginTransaction();
        AlgorithmParamRequest algorithmParamRequest = hpcJobInfo.getAlgorithmParamRequest();
        Set<AlgorithmParameter> algorithmParameters = algorithmParamRequest.getAlgorithmParameters();
        for (AlgorithmParameter algorithmParameter : algorithmParameters) {
            session.saveOrUpdate(algorithmParameter);
        }
        JvmOptions jvmOptions = algorithmParamRequest.getJvmOptions();
        if(jvmOptions != null){
        	session.saveOrUpdate(jvmOptions);
        }
        session.saveOrUpdate(algorithmParamRequest);
        session.saveOrUpdate(hpcJobInfo);
        transaction.commit();
    }

    @Override
    public void remove(HpcJobInfo hpcJobInfo) {
        Transaction transaction = session.beginTransaction();
        session.delete(hpcJobInfo);
        transaction.commit();
    }

    @Override
    public HpcJobInfo findById(long id) {
        return session.load(HpcJobInfo.class, id);
    }

    @Override
    public List<HpcJobInfo> findByHpcAccount(HpcAccount hpcAccount) {
        Query query = session.createQuery("FROM HpcJobInfo WHERE hpcAccountId = ?");
        query.setLong(0, hpcAccount.getId());
        return query.list();
    }

    @Override
    public List<HpcJobInfo> findByStatus(int status) {
        Query query = session.createQuery("FROM HpcJobInfo WHERE status = ?");
        query.setInteger(0, status);
        return query.list();
    }
}
