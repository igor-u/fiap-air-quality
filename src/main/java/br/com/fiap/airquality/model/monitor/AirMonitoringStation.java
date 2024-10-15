package br.com.fiap.airquality.model.monitor;

import br.com.fiap.airquality.model.device.Device;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "air_monitoring_stations")
public class AirMonitoringStation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAirMonitoringDeviceId")
    @SequenceGenerator(name = "seqAirMonitoringDeviceId", sequenceName = "SEQ_AIR_MONITORING_DEVICE_ID", allocationSize = 1)
    @Column(name = "station_id")
    private Long stationId;

    @OneToMany
    private Set<Device> devices = new HashSet<>();

    private String country;

    private String city;

}
