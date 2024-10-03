CREATE OR REPLACE TRIGGER unhealthy_air_alert
AFTER UPDATE OF AQI ON air_quality_sensors
FOR EACH ROW
DECLARE
    v_aqi air_quality_sensors.AQI%TYPE;
    v_log_text VARCHAR2(200) := 'The air is unhealthy in ' || :NEW.SITE;
BEGIN
    v_aqi := :NEW.AQI;
    IF v_aqi >= 151 THEN
    send_air_monitoring_log(:NEW.DEVICE_ID, v_log_text);
    END IF;
END;
/
