CREATE OR REPLACE TRIGGER high_co2_concentration_level_alert
AFTER UPDATE OF CO2_PPM ON gas_leak_detectors
FOR EACH ROW
DECLARE
    v_co2 gas_leak_detectors.CO2_PPM%TYPE;
    v_log_text VARCHAR2(80) := 'There is a high concentration level of CO2 in ' || :NEW.SITE;
BEGIN
    v_co2 := :NEW.CO2_PPM;
    IF v_co2 >= 5000 THEN
    send_air_monitoring_log(:NEW.DEVICE_ID, v_log_text);
    END IF;
END;
/
