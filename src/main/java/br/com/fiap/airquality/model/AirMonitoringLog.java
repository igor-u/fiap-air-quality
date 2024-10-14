package br.com.fiap.airquality.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "air_monitoring_logs")
public class AirMonitoringLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAirMonitoringLogId")
    @SequenceGenerator(name = "seqAirMonitoringLogId", sequenceName = "SEQ_AIR_MONITORING_LOG_ID", allocationSize = 1)
    @Column(name = "log_id")
    private Long logId;

    @Column(name = "device_id")
    private Long deviceId;

    private String from;

    private String to;

    private String subject;

    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

}