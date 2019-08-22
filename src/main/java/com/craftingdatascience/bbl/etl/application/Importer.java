package com.craftingdatascience.bbl.etl.application;

import com.craftingdatascience.bbl.etl.domain.FileReader;
import com.craftingdatascience.bbl.etl.domain.source.SourceComposition;
import com.craftingdatascience.bbl.etl.domain.source.SourceProduct;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Component
public class Importer implements Runnable {

    private final FileReader<SourceProduct> sourceProductFileReader;
    private final FileReader<SourceComposition> sourceCompositionFileReader;

    public Importer(
            FileReader<SourceProduct> sourceProductFileReader,
            FileReader<SourceComposition> sourceCompositionFileReader
    ) {
        this.sourceProductFileReader = sourceProductFileReader;
        this.sourceCompositionFileReader = sourceCompositionFileReader;
    }

    public void run() {
        try {
            System.out.println("Retrieving data from files...");
            // This could be read directly from a blob storage
            InputStream productsInputStream = Files.newInputStream(ResourceUtils.getFile("classpath:models.csv").toPath());
            InputStream compositionsInputStream = Files.newInputStream(ResourceUtils.getFile("classpath:compositions.csv").toPath());

            System.out.println("Parsing data and mapping to POJOs...");
            sourceCompositionFileReader.read(compositionsInputStream)
                .forEach(System.out::println);
            sourceProductFileReader.read(productsInputStream)
                .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Something went wrong here...");
        }
        System.out.println("Job's done!");
    }
}
