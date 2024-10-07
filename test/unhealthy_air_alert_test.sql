INSERT INTO air_quality_sensors (AQI, SITE) VALUES (50, 'John''s Courtyard');

UPDATE air_quality_sensors SET AQI = 200 WHERE SITE = 'John''s Courtyard';

SELECT "LOG_ID", "DEVICE_ID", "FROM", "TO", "TEXT", "TIME" FROM air_monitoring_logs;