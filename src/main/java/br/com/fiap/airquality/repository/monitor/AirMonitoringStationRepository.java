package br.com.fiap.airquality.repository.monitor;

import br.com.fiap.airquality.domain.monitor.AirMonitoringStation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AirMonitoringStationRepository extends MongoRepository<AirMonitoringStation, UUID> {
    AirMonitoringStation findByCountry(String brazil);
}
