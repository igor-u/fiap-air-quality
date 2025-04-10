package br.com.fiap.airquality.service.device;

import br.com.fiap.airquality.exception.EntryNotFoundException;
import br.com.fiap.airquality.domain.device.impl.AirQualitySensor;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AirQualitySensorService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public AirQualitySensorService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public AirQualitySensor create(AirQualitySensor airQualitySensor) {
        return deviceRepository.save(airQualitySensor);
    }

    public AirQualitySensor findById(UUID id) {
        return (AirQualitySensor) deviceRepository.findById(id)
                .orElseThrow(EntryNotFoundException::new);
    }

    public List<AirQualitySensor> findAll() {
        return new ArrayList<>(deviceRepository.findAll()
                .stream()
                .map(device -> (AirQualitySensor) device)
                .toList());
    }

    public void delete(UUID id) {
        deviceRepository.delete(
                deviceRepository.findById(id)
                        .orElseThrow(EntryNotFoundException::new));
    }

    public AirQualitySensor update(AirQualitySensor airQualitySensor) {

        AirQualitySensor optionalAirQualitySensor = (AirQualitySensor) deviceRepository
                .findById(airQualitySensor.getId())
                .orElseThrow(EntryNotFoundException::new);

        if (optionalAirQualitySensor != null) {
            return deviceRepository.save(airQualitySensor);
        }

        else {
            throw new EntryNotFoundException();
        }

    }

}
