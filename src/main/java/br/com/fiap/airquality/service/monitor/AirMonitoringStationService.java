package br.com.fiap.airquality.service.monitor;

import br.com.fiap.airquality.model.device.Device;
import br.com.fiap.airquality.model.monitor.AirMonitoringStation;
import br.com.fiap.airquality.repository.monitor.AirMonitoringStationRepository;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirMonitoringStationService {

    private final AirMonitoringStationRepository airMonitoringStationRepository;
    private final DeviceRepository deviceRepository;

    @Autowired
    public AirMonitoringStationService(AirMonitoringStationRepository airMonitoringStationRepository, DeviceRepository deviceRepository) {
        this.airMonitoringStationRepository = airMonitoringStationRepository;
        this.deviceRepository = deviceRepository;
    }

    public AirMonitoringStation createStation(AirMonitoringStation airMonitoringStation) {
        return airMonitoringStationRepository.save(airMonitoringStation);
    }

    public AirMonitoringStation addDevice(Long stationId, Long deviceId) {
        Optional<AirMonitoringStation> station = airMonitoringStationRepository.findById(stationId);
        Optional<Device> device = deviceRepository.findById(deviceId);

        station
                .orElseThrow()
                .getDevices()
                .add(device.orElseThrow());

        return station.get();

    }

}
