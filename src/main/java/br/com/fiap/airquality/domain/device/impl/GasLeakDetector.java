package br.com.fiap.airquality.domain.device.impl;

import br.com.fiap.airquality.domain.device.Device;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
@TypeAlias("gas_leak_detector")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GasLeakDetector extends Device {

    private Double co2Ppm;

    private Double hcPpm;

    private Double ch4Ppm;

    private Double coPpm;

    private Double n2oPpm;

    private Double nh3Ppm;

    private Double noPpm;

}