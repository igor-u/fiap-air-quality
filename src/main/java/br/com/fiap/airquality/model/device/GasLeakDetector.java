package br.com.fiap.airquality.model.device;

import jakarta.persistence.*;

@Entity
@Table(name = "gas_leak_detectors")
public class GasLeakDetector extends Device {

    @Column(name = "CO2_PPM")
    private Double co2Ppm;

    @Column(name = "HC_PPM")
    private Double hcPpm;

    @Column(name = "CH4_PPM")
    private Double ch4Ppm;

    @Column(name = "CO_PPM")
    private Double coPpm;

    @Column(name = "N2O_PPM")
    private Double n2oPpm;

    @Column(name = "NH3_PPM")
    private Double nh3Ppm;

    @Column(name = "NO_PPM")
    private Double noPpm;

}