package br.com.fiap.airquality.service.monitor;

import br.com.fiap.airquality.model.monitor.AirMonitoringLog;
import br.com.fiap.airquality.repository.monitor.AirMonitoringLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AirMonitoringLogService {

    private final AirMonitoringLogRepository airMonitoringLogRepository;

    @Autowired
    public AirMonitoringLogService(AirMonitoringLogRepository airMonitoringLogRepository) {
        this.airMonitoringLogRepository = airMonitoringLogRepository;
    }

    public List<AirMonitoringLog> findByDateRange(Timestamp minTime, Timestamp maxTime){
        return airMonitoringLogRepository
                .findByDateRange(minTime, maxTime);
    }

    public AirMonitoringLog createLog(AirMonitoringLog airMonitoringLog) {
        return airMonitoringLogRepository.save(airMonitoringLog);
    }
}
