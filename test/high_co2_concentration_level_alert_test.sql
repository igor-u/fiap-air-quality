INSERT INTO gas_leak_detectors (CO2_PPM, SITE) VALUES (2000, 'Luke''s Courtyard');

UPDATE gas_leak_detectors SET CO2_PPM = 6000 WHERE SITE = 'Luke''s Courtyard';

SELECT "LOG_ID", "DEVICE_ID", "FROM", "TO", "TEXT", "TIME" FROM air_monitoring_logs;