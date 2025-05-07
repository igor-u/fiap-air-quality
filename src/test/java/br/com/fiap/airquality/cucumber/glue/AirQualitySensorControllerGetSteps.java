package br.com.fiap.airquality.cucumber.glue;

import br.com.fiap.airquality.domain.device.impl.AirQualitySensor;
import br.com.fiap.airquality.service.device.AirQualitySensorService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AirQualitySensorControllerGetSteps {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AirQualitySensorService airQualitySensorService;

    private ResultActions resultActions;

    @Given("^the following air quality sensors$")
    public void givenTheFollowingAirQualitySensors(List<AirQualitySensor> airQualitySensors) {
        when(airQualitySensorService.findAll()).thenReturn(airQualitySensors);
    }

    @When("the user sends a GET request to {string}")
    public void whenTheUserSendsAGetRequestTo(String path) throws Exception {
        resultActions = mockMvc.perform(get(path));
    }

    @Then("the get response status code should be {int}")
    public void thenTheGetResponseStatusCodeShouldBe(int statusCode) throws Exception {
        resultActions.andExpect(status().is(statusCode));
    }

    @And("the response body should be a list of air quality sensors containing")
    public void andTheResponseBodyShouldBeAListOfAirQualitySensorsContaining(String responseBody) throws Exception {
        resultActions.andExpect(content().json(responseBody));
    }

}
