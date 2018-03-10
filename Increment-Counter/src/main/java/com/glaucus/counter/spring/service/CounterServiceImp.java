package com.glaucus.counter.spring.service;

import com.glaucus.counter.spring.dao.CounterDao;
import com.glaucus.counter.spring.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Divyansh Goel
 *
 */
@Service
public class CounterServiceImp implements CounterService {

   @Autowired
   private CounterDao counterDao;

   @Transactional
   public boolean incrementCounter() {
       synchronized (counterDao) {
           Counter counter = new Counter();
           counter.setCounter(counterDao.getCounter().getCounter() + 1);
           counter.setId(counterDao.getCounter().getId());
           return counterDao.incrementCounter(counter);
       }
   }

   @Transactional
   public int getCounter() {
      return counterDao.getCounter().getCounter();
   }

}
