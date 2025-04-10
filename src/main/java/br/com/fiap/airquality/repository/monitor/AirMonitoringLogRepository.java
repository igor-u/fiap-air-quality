package br.com.fiap.airquality.repository.monitor;

import br.com.fiap.airquality.domain.monitor.AirMonitoringLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface AirMonitoringLogRepository extends MongoRepository<AirMonitoringLog, UUID> {

    // @Query("{ 'time' : { $gte: ?0, $lte: ?1 } }")
    List<AirMonitoringLog> findByTimeBetweenOrderByTimeDesc(Timestamp min, Timestamp max);

}
