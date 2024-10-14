package br.com.fiap.airquality.model.device;

import jakarta.persistence.*;

@Entity
@Table(name = "air_quality_sensors")
public class AirQualitySensor extends Device {

    private Double aqi;

    @Column(name = "temperature_celsius")
    private Double temperatureCelsius;

    @Column(name = "humidity_percentage")
    private Double humidityPercentage;

    @Column(name = "ECO2_PPM")
    private Double eco2Ppm;

    @Column(name = "TVOC_PPB")
    private Double tvocPpb;

}