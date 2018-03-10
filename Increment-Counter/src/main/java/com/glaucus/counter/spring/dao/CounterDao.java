package com.glaucus.counter.spring.dao;

import com.glaucus.counter.spring.model.Counter;

public interface CounterDao {
   boolean incrementCounter(Counter counter);
   Counter getCounter();
   void addCounterRow(Counter counter);
}
