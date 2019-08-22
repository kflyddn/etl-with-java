package com.craftingdatascience.bbl.etl.application;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ImporterRunner implements ApplicationRunner {
    private final Runnable importer;

    public ImporterRunner(
            Importer importer
    ) {
        this.importer = importer;
    }

    public void run(ApplicationArguments args) {
        importer.run();
    }
}
