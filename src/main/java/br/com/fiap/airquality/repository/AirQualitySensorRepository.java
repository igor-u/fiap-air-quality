package br.com.fiap.airquality.repository;

import br.com.fiap.airquality.model.device.AirQualitySensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirQualitySensorRepository extends JpaRepository<AirQualitySensor, Long> {
}
