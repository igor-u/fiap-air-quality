package br.com.fiap.airquality.model.device;

import br.com.fiap.airquality.model.monitor.AirMonitoringStation;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "devices_info")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAirMonitoringDeviceId")
    @SequenceGenerator(name = "seqAirMonitoringDeviceId", sequenceName = "SEQ_AIR_MONITORING_DEVICE_ID", allocationSize = 1)
    @Column(name = "device_id")
    @Getter
    private Long deviceId;

    @Transient
    private Device device;

    private String model;

    private DeviceStatus status;

    @ManyToOne
    private AirMonitoringStation station;

}

