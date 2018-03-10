package com.glaucus.counter.spring.dao;

import com.glaucus.counter.spring.model.Counter;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;

/**
 * @author Divyansh Goel
 */
@Repository
public class CounterDaoImp implements CounterDao {

   @Autowired
   private SessionFactory sessionFactory;

    /**
     * Method to increment the counter.
     * @param counter
     * @return
     */
   @Override
   public boolean incrementCounter(Counter counter) {

       try {
           Session session = sessionFactory.getCurrentSession();
           Query query = session.createQuery("update Counter set counter = :counter" +
                   " where id = :id");
           query.setParameter("counter", counter.getCounter());
           query.setParameter("id", counter.getId());
           int result = query.executeUpdate();
           if (result > 0){
               System.out.println("Counter Updated Successfully");
               return true;
           }
           else {
               System.out.println("Counter is not updated");
               return false;
           }
       }catch (JDBCException sql){
           System.out.println("SQL Exception Occured" + sql.getSQLException());
           return false;
       }
   }

    /**
     * get the current value of counter.
     * @return Counter Object having counter value and id.
     */
   @Override
   public Counter getCounter() {
       try {
           Query query = sessionFactory.getCurrentSession().createQuery("from Counter");
           if (!query.getResultList().isEmpty()){
               Counter counter = (Counter) query.getSingleResult();
               System.out.println("Counter value is:- " + counter.getCounter());
               return counter;
           }
           /**
            * Only run first time when no value is present in the table. Setting counter value to 0 in the Table.
            */
           else {
               Counter counter = new Counter();
               counter.setCounter(new Integer(0));
               addCounterRow(counter);
               return counter;
           }
       }catch (JDBCException sql){
           System.out.println("SQL Exception Occured" + sql.getSQLException());
           return null;
       }
   }

    /**
     *
     * @param counter
     */
    @Override
    public void addCounterRow(Counter counter) {
        sessionFactory.getCurrentSession().save(counter);
    }

}
