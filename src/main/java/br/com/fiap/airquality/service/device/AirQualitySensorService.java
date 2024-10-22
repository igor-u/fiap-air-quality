package br.com.fiap.airquality.service.device;

import br.com.fiap.airquality.model.device.impl.AirQualitySensor;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirQualitySensorService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public AirQualitySensorService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public AirQualitySensor createDevice(AirQualitySensor airQualitySensor) {
        return deviceRepository.save(airQualitySensor);
    }

}
