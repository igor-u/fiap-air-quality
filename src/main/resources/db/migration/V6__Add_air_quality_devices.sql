CREATE TABLE air_quality_sensors (
    "ID" INTEGER DEFAULT SEQ_AIR_MONITORING_DEVICE_ID.nextval,
    "AQI" FLOAT(53),
    "TEMPERATURE_CELSIUS" FLOAT(53),
    "HUMIDITY_PERCENTAGE" FLOAT(53),
    "ECO2_PPM" FLOAT(53),
    "TVOC_PPB" FLOAT(53)
    );

ALTER TABLE air_quality_sensors
ADD (
CONSTRAINT pk_air_quality_sensors PRIMARY KEY ("ID"),
CONSTRAINT fk_air_quality_sensors_devices FOREIGN KEY ("ID") REFERENCES devices("ID")
);

CREATE TABLE gas_leak_detectors (
    "ID" INTEGER DEFAULT SEQ_AIR_MONITORING_DEVICE_ID.nextval,
    "CO2_PPM" FLOAT(53),
    "HC_PPM" FLOAT(53),
    "CH4_PPM" FLOAT(53),
    "CO_PPM" FLOAT(53),
    "N2O_PPM" FLOAT(53),
    "NH3_PPM" FLOAT(53),
    "NO_PPM" FLOAT(53)
    );

ALTER TABLE gas_leak_detectors
ADD (
CONSTRAINT pk_gas_leak_detectors PRIMARY KEY ("ID"),
CONSTRAINT fk_gas_leak_detectors_devices FOREIGN KEY ("ID") REFERENCES devices("ID")
);

CREATE TABLE ozone_monitoring_instruments (
    "ID" INTEGER DEFAULT SEQ_AIR_MONITORING_DEVICE_ID.nextval,
    "ORBIT_HEIGHT_KM" FLOAT(53),
    "NO2_10E15_MOLECULES_CM_2" FLOAT(53),
    "SO2_10E15_MOLECULES_CM_2" FLOAT(53),
    "BRO_10E15_MOLECULES_CM_2" FLOAT(53),
    "HCHO_10E15_MOLECULES_CM_2" FLOAT(53),
    "AEROSOL_AOD" FLOAT(53)
    );

ALTER TABLE ozone_monitoring_instruments
ADD (
CONSTRAINT pk_ozone_monitoring_instruments PRIMARY KEY ("ID"),
CONSTRAINT fk_ozone_monitoring_instruments_devices FOREIGN KEY ("ID") REFERENCES devices("ID")
);