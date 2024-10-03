INSERT INTO ozone_monitoring_instruments (DEVICE_ID, AEROSOL_AOD, AREA) VALUES (seq_air_monitoring_device_id.nextval, 0.5, 'Paul´s Courtyard');

UPDATE ozone_monitoring_instruments SET AEROSOL_AOD = 0.8 WHERE AREA = 'Paul´s Courtyard';

SELECT "LOG_ID", "DEVICE_ID", "FROM", "TO", "TEXT", "TIME" FROM air_monitoring_logs;