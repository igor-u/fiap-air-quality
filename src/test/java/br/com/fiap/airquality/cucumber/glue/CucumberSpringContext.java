package br.com.fiap.airquality.cucumber.glue;

import br.com.fiap.airquality.service.device.AirQualitySensorService;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@CucumberContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class CucumberSpringContext {

    @MockBean
    private AirQualitySensorService airQualitySensorService;

}
