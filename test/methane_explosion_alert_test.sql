INSERT INTO gas_leak_detectors (CH4_PPM, SITE) VALUES (15000, 'Marie''s Courtyard');

UPDATE gas_leak_detectors SET CH4_PPM = 60000 WHERE SITE = 'Marie''s Courtyard';

SELECT "LOG_ID", "DEVICE_ID", "FROM", "TO", "TEXT", "TIME" FROM air_monitoring_logs;