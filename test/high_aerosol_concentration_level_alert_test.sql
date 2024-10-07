INSERT INTO ozone_monitoring_instruments (AEROSOL_AOD, AREA) VALUES (0.5, 'Paul''s Courtyard');

UPDATE ozone_monitoring_instruments SET AEROSOL_AOD = 0.8 WHERE AREA = 'Paul''s Courtyard';

SELECT "LOG_ID", "DEVICE_ID", "FROM", "TO", "TEXT", "TIME" FROM air_monitoring_logs;