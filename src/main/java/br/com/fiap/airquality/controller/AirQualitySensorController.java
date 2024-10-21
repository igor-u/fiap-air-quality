package br.com.fiap.airquality.controller;

import br.com.fiap.airquality.model.device.impl.AirQualitySensor;
import br.com.fiap.airquality.service.AirQualitySensorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("air_quality")
public class AirQualitySensorController {

    private final AirQualitySensorService airQualitySensorService;

    @Autowired
    public AirQualitySensorController(AirQualitySensorService airQualitySensorService) {
        this.airQualitySensorService = airQualitySensorService;
    }

    @PostMapping("/air_quality_sensor")
    @Transactional
    public AirQualitySensor createDevice(@RequestBody AirQualitySensor airQualitySensor) {
        return airQualitySensorService.createDevice(airQualitySensor);
    }
}
