package br.com.fiap.airquality.service.monitor;

import br.com.fiap.airquality.exception.EntryNotFoundException;
import br.com.fiap.airquality.domain.device.Device;
import br.com.fiap.airquality.domain.monitor.AirMonitoringStation;
import br.com.fiap.airquality.repository.monitor.AirMonitoringStationRepository;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AirMonitoringStationService {

    private final AirMonitoringStationRepository airMonitoringStationRepository;
    private final DeviceRepository deviceRepository;

    @Autowired
    public AirMonitoringStationService(AirMonitoringStationRepository airMonitoringStationRepository,
            DeviceRepository deviceRepository) {
        this.airMonitoringStationRepository = airMonitoringStationRepository;
        this.deviceRepository = deviceRepository;
    }

    public AirMonitoringStation create(AirMonitoringStation airMonitoringStation) {
        return airMonitoringStationRepository.save(airMonitoringStation);
    }

    public AirMonitoringStation addDevice(UUID stationId, UUID deviceId) {
        Optional<AirMonitoringStation> station = airMonitoringStationRepository.findById(stationId);
        Optional<Device> device = deviceRepository.findById(deviceId);

        station
                .orElseThrow(EntryNotFoundException::new)
                .getDevices()
                .add(device.orElseThrow(EntryNotFoundException::new));

        return station.get();

    }

    public AirMonitoringStation findById(UUID id) {
        return airMonitoringStationRepository.findById(id).orElseThrow(EntryNotFoundException::new);
    }

    public List<AirMonitoringStation> findAll() {
        return new ArrayList<>(airMonitoringStationRepository.findAll());
    }

    public void delete(UUID id) {
        airMonitoringStationRepository.delete(
                airMonitoringStationRepository.findById(id)
                        .orElseThrow(EntryNotFoundException::new));
    }

    public AirMonitoringStation update(AirMonitoringStation airMonitoringStation) {

        Optional<AirMonitoringStation> optionalAirMonitoringStation = airMonitoringStationRepository
                .findById(airMonitoringStation.getId());

        if (optionalAirMonitoringStation.isPresent()) {
            return airMonitoringStationRepository.save(airMonitoringStation);
        }

        else {
            throw new EntryNotFoundException();
        }

    }

}
