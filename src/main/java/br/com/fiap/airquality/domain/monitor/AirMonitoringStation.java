package br.com.fiap.airquality.domain.monitor;

import br.com.fiap.airquality.domain.UuidIdentifiedEntity;
import br.com.fiap.airquality.domain.device.Device;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Document(collection = "air_monitoring_stations")
@TypeAlias("air_monitoring_station")
@SuperBuilder
@Getter
@Setter
public class AirMonitoringStation extends UuidIdentifiedEntity {

    private Set<Device> devices;

    private String country;

    private String city;

}
