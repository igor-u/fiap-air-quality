package br.com.fiap.airquality.domain.device.impl;

import br.com.fiap.airquality.domain.device.Device;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "devices")
@Data
@TypeAlias("ozone_monitoring_instrument")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OzoneMonitoringInstrument extends Device {

    private Double orbitHeightKm;

    @Field(name = "NO2_10e15_molecules_per_cm_2")
    private Double NO2x10e15moleculesPerCm2;

    @Field(name = "SO2_10e15_molecules_per_cm_2")
    private Double SO2x10e15moleculesPerCm2;

    @Field(name = "BrO2_10e15_molecules_per_cm_2")
    private Double BrO2x10e15moleculesPerCm2;

    @Field(name = "HCHO_10e15_molecules_per_cm_2")
    private Double HCHO2x10e15moleculesPerCm2;

    private Double aerosolOpticalDepth;

}
