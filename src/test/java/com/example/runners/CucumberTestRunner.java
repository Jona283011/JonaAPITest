package com.example.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Ruta de los archivos .feature
        glue = {"com/example/steps"}, // Paquete de las step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // Opciones de salida
        monochrome = true // Formato limpio en la consola
)
public class CucumberTestRunner {
}

