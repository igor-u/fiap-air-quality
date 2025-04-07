package br.com.fiap.airquality.domain.monitor;


import br.com.fiap.airquality.domain.UuidIdentifiedEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import java.sql.Timestamp;

@Document(collection = "air_monitoring_logs")
@TypeAlias("air_monitoring_log")
@SuperBuilder
@Getter
@Setter
public class AirMonitoringLog extends UuidIdentifiedEntity {

    private Long deviceId;

    private String fromEmail;

    private String toEmail;

    private String subject;

    private String message;

    private Timestamp time;

}