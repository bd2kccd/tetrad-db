package edu.pitt.dbmi.tetrad.db;

import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParamRequest;
import edu.pitt.dbmi.tetrad.db.entity.AlgorithmParameter;
import edu.pitt.dbmi.tetrad.db.entity.DataValidation;
import edu.pitt.dbmi.tetrad.db.entity.HpcAccount;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobInfo;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobLog;
import edu.pitt.dbmi.tetrad.db.entity.HpcJobLogDetail;
import edu.pitt.dbmi.tetrad.db.entity.HpcParameter;
import edu.pitt.dbmi.tetrad.db.entity.JvmOption;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
            configuration.addAnnotatedClass(AlgorithmParameter.class);
            configuration.addAnnotatedClass(AlgorithmParamRequest.class);
            configuration.addAnnotatedClass(DataValidation.class);
            configuration.addAnnotatedClass(HpcAccount.class);
            configuration.addAnnotatedClass(HpcJobInfo.class);
            configuration.addAnnotatedClass(HpcJobLog.class);
            configuration.addAnnotatedClass(HpcJobLogDetail.class);
            configuration.addAnnotatedClass(JvmOption.class);
            configuration.addAnnotatedClass(HpcParameter.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
        	String tetradRunningWarning = "Tetrad application is already running...";
            System.err.println(tetradRunningWarning);
        	//System.err.println(e.getMessage());
            throw new ExceptionInInitializerError(tetradRunningWarning);
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

        HpcAccount computingAccount = new HpcAccount();
        computingAccount.setConnectionName("psc");
        computingAccount.setUsername("");
        computingAccount.setPassword("");
        computingAccount.setScheme("https");
        computingAccount.setHostname("");
        computingAccount.setPort(443);
        computingAccount.setCreatedDate(new Date());
        session.save(computingAccount);

        session.getTransaction().commit();
        session.close();
        TetradDatabaseApplication.shutdown();
    }

}
