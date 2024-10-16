package br.com.fiap.airquality.model.monitor;

import br.com.fiap.airquality.model.device.Device;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "air_monitoring_stations")
public class AirMonitoringStation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAirMonitoringStationId")
    @SequenceGenerator(name = "seqAirMonitoringStationId", sequenceName = "SEQ_AIR_MONITORING_STATION_ID", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @OneToMany
    public Set<Device> devices = new HashSet<>();

    public String country;

    public String city;

}
