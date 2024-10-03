CREATE OR REPLACE TRIGGER high_aerosol_concentration_level_alert
AFTER UPDATE OF AEROSOL_AOD ON ozone_monitoring_instruments
FOR EACH ROW
DECLARE
    v_aod ozone_monitoring_instruments.AEROSOL_AOD%TYPE;
    v_log_text VARCHAR2(80) := 'The atmosphere is possibly highly polluted in ' || :NEW.AREA;
BEGIN
    v_aod := :NEW.AEROSOL_AOD;
    IF v_aod >= 0.7 THEN
    send_air_monitoring_log(:NEW.DEVICE_ID, v_log_text);
    END IF;
END;
/
