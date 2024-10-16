package br.com.fiap.airquality.service;

import br.com.fiap.airquality.model.device.impl.AirQualitySensor;
import br.com.fiap.airquality.repository.AirQualitySensorRepository;
import br.com.fiap.airquality.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirQualitySensorService {

    private final DeviceRepository deviceRepository;
    private final AirQualitySensorRepository airQualitySensorRepository;

    @Autowired
    public AirQualitySensorService(DeviceRepository deviceRepository, AirQualitySensorRepository airQualitySensorRepository) {
        this.deviceRepository = deviceRepository;
        this.airQualitySensorRepository = airQualitySensorRepository;
    }

    public AirQualitySensor createDevice(AirQualitySensor airQualitySensor) {
        deviceRepository.save(airQualitySensor);
        return airQualitySensorRepository.save(airQualitySensor);
    }

}
