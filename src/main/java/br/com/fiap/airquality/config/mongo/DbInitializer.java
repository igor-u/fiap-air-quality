package br.com.fiap.airquality.config.mongo;

import br.com.fiap.airquality.domain.device.Device;
import br.com.fiap.airquality.domain.device.DeviceStatus;
import br.com.fiap.airquality.domain.device.impl.AirQualitySensor;
import br.com.fiap.airquality.domain.device.impl.OzoneMonitoringInstrument;
import br.com.fiap.airquality.domain.monitor.AirMonitoringStation;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import br.com.fiap.airquality.repository.monitor.AirMonitoringStationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class DbInitializer implements CommandLineRunner {

        private final AirMonitoringStationRepository stationRepository;
        private final DeviceRepository deviceRepository;

        public DbInitializer(AirMonitoringStationRepository stationRepository, DeviceRepository deviceRepository) {
                this.stationRepository = stationRepository;
                this.deviceRepository = deviceRepository;
        }

        @Override
        public void run(String... args) throws Exception {
                Device device1 = AirQualitySensor.builder()
                                .model("SensorPro")
                                .status(DeviceStatus.INACTIVE)
                                .AQI(0.0)
                                .build();

                Device device2 = OzoneMonitoringInstrument.builder()
                                .model("AirGuard")
                                .status(DeviceStatus.INACTIVE)
                                .aerosolOpticalDepth(0.0)
                                .BrO2x10e15moleculesPerCm2(0.0)
                                .HCHO2x10e15moleculesPerCm2(0.0)
                                .NO2x10e15moleculesPerCm2(0.0)
                                .SO2x10e15moleculesPerCm2(0.0)
                                .orbitHeightKm(0.0)
                                .build();

                AirMonitoringStation station1 = AirMonitoringStation.builder()
                                .country("Brazil")
                                .city("São Paulo")
                                .devices(new HashSet<>(List.of(device1)))
                                .build();

                AirMonitoringStation station2 = AirMonitoringStation.builder()
                                .country("Brazil")
                                .city("Rio de Janeiro")
                                .devices(new HashSet<>(List.of(device2)))
                                .build();

                deviceRepository.save(device1);
                deviceRepository.save(device2);
                stationRepository.save(station1);
                stationRepository.save(station2);
        }
}
