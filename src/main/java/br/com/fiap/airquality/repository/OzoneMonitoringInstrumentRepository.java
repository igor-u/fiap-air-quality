package br.com.fiap.airquality.repository;

import br.com.fiap.airquality.model.device.OzoneMonitoringInstrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OzoneMonitoringInstrumentRepository extends JpaRepository<OzoneMonitoringInstrument, Long> {
}
