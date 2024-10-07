CREATE TABLE air_monitoring_logs (
    "LOG_ID" INT DEFAULT SEQ_AIR_MONITORING_LOG_ID.nextval,
    "DEVICE_ID" INT,
    "FROM" VARCHAR(50) DEFAULT 'sensor@airsensorcompany.com',
    "TO" VARCHAR(50) DEFAULT 'monitor@airsensormonitor.com',
    "SUBJECT" VARCHAR(50),
    "TEXT" VARCHAR(255),
    "TIME" TIMESTAMP
    );

ALTER TABLE air_monitoring_logs
ADD CONSTRAINT pk_air_monitoring_logs PRIMARY KEY ("LOG_ID");
