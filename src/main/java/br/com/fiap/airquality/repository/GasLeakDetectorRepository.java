package br.com.fiap.airquality.repository;

import br.com.fiap.airquality.model.device.impl.GasLeakDetector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GasLeakDetectorRepository extends JpaRepository<GasLeakDetector, Long> {
}
