Feature: Air Quality Sensor API

  Scenario: Get all air quality sensors
    Given the following air quality sensors
    | model     | status |
    | AirGuard  | ACTIVE |
    | SensorPro | ACTIVE |
    When the user sends a GET request to "/air_quality/air_quality_sensor"
    Then the get response status code should be 200
    And the response body should be a list of air quality sensors containing
    """
      [
        {
          "model":"AirGuard",
          "status":"ACTIVE",
          "aqi":null,
          "temperatureCelsius":null,
          "humidityPercentage":null,
          "eco2Ppm":null,
          "tvocPpb":null
        },
        {
          "model":"SensorPro",
          "status":"ACTIVE",
          "aqi":null,
          "temperatureCelsius":null,
          "humidityPercentage":null,
          "eco2Ppm":null,
          "tvocPpb":null
        }
      ]
      """

  Scenario: Successfully create a new air quality sensor with ADMIN role
    Given the request body is
      """
      {
      "model":"SafeSpace",
      "status":"ACTIVE"
      }
      """
    When the user sends a POST request with ADMIN role to "/air_quality/air_quality_sensor"
    Then the created post response status code should be 201
    And the response body should contain the created air quality sensor

  Scenario: Fail to create a new air quality sensor due to insufficient permissions
    Given the request body for the new sensor is
      """
      {
      "model":"ToxicCloud",
      "status":"INACTIVE"
      }
      """
    But the user sends a POST request without ADMIN role to "/air_quality/air_quality_sensor"
    Then the denied post response status code should be 403
