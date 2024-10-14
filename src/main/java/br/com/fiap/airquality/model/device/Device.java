package br.com.fiap.airquality.model.device;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAirMonitoringDeviceId")
    @SequenceGenerator(name = "seqAirMonitoringDeviceId", sequenceName = "SEQ_AIR_MONITORING_DEVICE_ID", allocationSize = 1)
    @Column(name = "device_id")
    private Long deviceId;

    private String model;

    private DeviceStatus status;

    private String area;

}
