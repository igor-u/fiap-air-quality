package br.com.fiap.airquality.cucumber.glue;

import br.com.fiap.airquality.domain.device.impl.AirQualitySensor;
import br.com.fiap.airquality.service.device.AirQualitySensorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AirQualitySensorControllerPostSteps {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AirQualitySensorService airQualitySensorService;

    private ResultActions resultActions;

    private String requestBody;

    private AirQualitySensor createdSensor;

    @Given("the request body is")
    public void givenTheRequestBodyIs(String requestBody) throws JsonProcessingException {
        this.requestBody = requestBody;
        createdSensor = objectMapper.readValue(requestBody, AirQualitySensor.class);
    }

    @When("the user sends a POST request with ADMIN role to {string}")
    public void whenTheUserSendsAPostRequestWithAdminRoleTo(String path) throws Exception {
        when(airQualitySensorService.create(createdSensor)).thenReturn(createdSensor);

        resultActions = mockMvc.perform(post(path).with(user("admin").roles("ADMIN"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));
    }

    @Then("the created post response status code should be {int}")
    public void thenTheCreatedPostResponseStatusShouldBe(int statusCode) throws Exception {
        resultActions.andExpect(status().is(statusCode));
    }

    @And("the response body should contain the created air quality sensor")
    public void andTheResponseBodyShouldContainTheCreatedAirQualitySensor() throws UnsupportedEncodingException, JsonProcessingException {

        String responseBodyContent = resultActions.andReturn().getResponse().getContentAsString();

        AirQualitySensor retrievedSensor = objectMapper.readValue(responseBodyContent, AirQualitySensor.class);

        Assert.assertEquals(createdSensor, retrievedSensor);

    }

    @Given("the request body for the new sensor is")
    public void givenTheRequestBodyForTheNewSensorIs(String requestBody) throws JsonProcessingException {
        this.requestBody = requestBody;
        createdSensor = objectMapper.readValue(requestBody, AirQualitySensor.class);
    }

    @But("the user sends a POST request without ADMIN role to {string}")
    public void theUserSendsAPostRequestWithoutAdminRoleTo(String path) throws Exception {
        resultActions = mockMvc.perform(post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));
    }

    @Then("the denied post response status code should be {int}")
    public void thenTheDeniedPostResponseStatusShouldBe(int statusCode) throws Exception {
        resultActions.andExpect(status().is(statusCode));
    }

}
