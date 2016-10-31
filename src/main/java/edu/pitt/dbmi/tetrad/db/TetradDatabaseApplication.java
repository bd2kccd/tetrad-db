package edu.pitt.dbmi.tetrad.db;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParameter;
import edu.pitt.dbmi.tetrad.db.entity.ComputingAccount;
import edu.pitt.dbmi.tetrad.db.entity.DataValidation;
import edu.pitt.dbmi.tetrad.db.entity.JobInfo;
import edu.pitt.dbmi.tetrad.db.entity.JvmOption;

/**
 * 
 * Oct 24, 2016 5:21:16 PM
 * 
 * @author Chirayu (Kong) Wongchokprasitti, PhD
 * 
 */
public class TetradDatabaseApplication {

    private static final SessionFactory sessionFactory;

    static {
	try {
	    Configuration configuration = new Configuration();
	    // Mapping
	    configuration.addAnnotatedClass(ComputingAccount.class);
	    configuration.addAnnotatedClass(JobInfo.class);
	    configuration.addAnnotatedClass(AlgorithmParamRequest.class);
	    configuration.addAnnotatedClass(DataValidation.class);
	    configuration.addAnnotatedClass(AlgorithmParameter.class);
	    configuration.addAnnotatedClass(JvmOption.class);
	    
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	} catch (Throwable e) {
	    System.err.println(e.getMessage());
	    throw new ExceptionInInitializerError(e);
	}
    }

    public static SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public static void shutdown() {
	sessionFactory.close();
    }

    public static void main(String[] args) { 
	Session session = TetradDatabaseApplication.getSessionFactory()
		.openSession();
	session.beginTransaction();

	ComputingAccount computingAccount = new ComputingAccount();
	computingAccount.setConnectionName("psc");
	computingAccount.setUsername("ccd@pitt.edu");
	computingAccount.setPassword("causalinference");
	computingAccount.setScheme("https");
	computingAccount.setHostname("ccd1.vm.bridges.psc.edu");
	computingAccount.setPort(443);
	computingAccount.setCreatedDate(new Date());
	session.save(computingAccount);

	session.getTransaction().commit();
	session.close();
	TetradDatabaseApplication.shutdown();
    }
    
}
