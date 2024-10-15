package br.com.fiap.airquality.repository;

import br.com.fiap.airquality.model.monitor.AirMonitoringLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirMonitoringLogRepository extends JpaRepository<AirMonitoringLog, Long> {
}
