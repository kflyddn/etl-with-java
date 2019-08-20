package com.craftingdatascience.bbl.etl.application;

import org.springframework.stereotype.Component;

@Component
public class Importer implements Runnable {
  public void run() {
    System.out.println("Hello world");
  }
}
