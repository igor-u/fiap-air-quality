package br.com.fiap.airquality.domain.device.impl;

import br.com.fiap.airquality.domain.device.Device;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
@Data
@TypeAlias("air_quality_sensor")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AirQualitySensor extends Device {

    private Double AQI;

    private Double temperatureCelsius;

    private Double humidityPercentage;

    private Double eCO2Ppm;

    private Double TVOCPpb;

}