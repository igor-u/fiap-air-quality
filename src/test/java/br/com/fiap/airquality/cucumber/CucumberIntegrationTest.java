package br.com.fiap.airquality.cucumber;

import br.com.fiap.airquality.AirQualityApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "br.com.fiap.airquality.cucumber.glue")
@SpringBootTest(classes = { AirQualityApplication.class })
public class CucumberIntegrationTest {
}
