CREATE OR REPLACE PROCEDURE send_air_monitoring_log (device_id IN air_monitoring_logs.DEVICE_ID%TYPE, text IN air_monitoring_logs.TEXT%TYPE)
IS
BEGIN
    INSERT INTO air_monitoring_logs ("LOG_ID", "DEVICE_ID", "TEXT", "TIME")
    VALUES
    (seq_air_monitoring_log_id.NEXTVAL,
    device_id,
    text,
    LOCALTIMESTAMP
    );
END;
/

