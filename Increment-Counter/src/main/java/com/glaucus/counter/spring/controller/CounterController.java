package com.glaucus.counter.spring.controller;

import com.glaucus.counter.spring.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Divyansh Goel
 */
@Controller
public class CounterController {

    @Autowired
   private CounterService counterService;

    /**
     * A "Get" method to get the current value of counter.
     * @param model
     * @return
     */

    // Latest annotation which replaces @RequestMapping
   @GetMapping("/")
   public String getCounter(Model model) {
            model.addAttribute("counter",counterService.getCounter());
      return "counterValue";
   }

    /**
     * Method to increment the counter.
     */
   @PostMapping("/incrementCounter")
   public void incrementCounter() {
      boolean bool = counterService.incrementCounter();
      if (bool) {
          System.out.println("Counter Successfully Incremented");
      }
      else
          System.out.println("OOPS!! Counter not Incremented");
   }
}
