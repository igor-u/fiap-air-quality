CREATE TABLE gas_leak_detectors (
    "DEVICE_ID" INT,
    "MODEL" VARCHAR(30),
    "STATUS" VARCHAR(30),
    "SITE" VARCHAR2(30),
    "CO2_PPM" NUMBER,
    "HC_PPM" NUMBER,
    "CH4_PPM" NUMBER,
    "CO_PPM" NUMBER,
    "N2O_PPM" NUMBER,
    "NH3_PPM" NUMBER,
    "NO_PPM" NUMBER
    );

ALTER TABLE gas_leak_detectors
ADD CONSTRAINT pk_gas_leak_detectors PRIMARY KEY ("DEVICE_ID");
