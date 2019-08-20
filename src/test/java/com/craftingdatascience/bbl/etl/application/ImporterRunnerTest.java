package com.craftingdatascience.bbl.etl.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.ApplicationArguments;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ImporterRunnerTest {

  @Mock
  private Importer importer;

  @Test
  void ImporterRunner_should_run_importer() {
    // Given
    ImporterRunner importerRunner = new ImporterRunner(importer);

    // When
    importerRunner.run(mock(ApplicationArguments.class));

    // Then
    verify(importer).run();
  }
}
