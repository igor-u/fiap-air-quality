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

    private Double CO2Ppm;

    private Double HCPpm;

    private Double CH4Ppm;

    private Double COPpm;

    private Double N2OPpm;

    private Double NH3Ppm;

    private Double NOPpm;

}