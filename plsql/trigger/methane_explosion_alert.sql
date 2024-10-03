CREATE OR REPLACE TRIGGER methane_explosion_alert
AFTER UPDATE OF CH4_PPM ON gas_leak_detectors
FOR EACH ROW
DECLARE
    v_ch4 gas_leak_detectors.CH4_PPM%TYPE;
    v_log_text VARCHAR2(80) := 'There is a high chance of a methane explosion to occur in ' || :NEW.SITE;
BEGIN
    v_ch4 := :NEW.CH4_PPM;
    IF v_ch4 >= 50000 THEN
    send_air_monitoring_log(:NEW.DEVICE_ID, v_log_text);
    END IF;
END;
/
