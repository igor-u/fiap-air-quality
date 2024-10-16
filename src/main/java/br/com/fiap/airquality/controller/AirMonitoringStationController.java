package br.com.fiap.airquality.controller;

import br.com.fiap.airquality.model.device.impl.AirQualitySensor;
import br.com.fiap.airquality.model.monitor.AirMonitoringStation;
import br.com.fiap.airquality.service.AirMonitoringStationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("air_quality")
public class AirMonitoringStationController {

    private final AirMonitoringStationService airMonitoringStationService;

    @Autowired
    public AirMonitoringStationController(AirMonitoringStationService airMonitoringStationService) {
        this.airMonitoringStationService = airMonitoringStationService;
    }

    @PostMapping("/station")
    @Transactional
    public AirMonitoringStation create(@RequestBody AirMonitoringStation airMonitoringStation) {
        return airMonitoringStationService.createStation(airMonitoringStation);
    }

    @PatchMapping("/station/setDevice")
    @Transactional
    public AirMonitoringStation setAirQualitySensor(@RequestParam Long stationId, @RequestParam Long deviceId) {
        return airMonitoringStationService.setDevice(stationId, deviceId);
    }

}
