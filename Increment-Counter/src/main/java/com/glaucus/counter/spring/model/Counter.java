package com.glaucus.counter.spring.model;

import javax.persistence.*;

@Entity
public class Counter {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column
   private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
