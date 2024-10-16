CREATE SEQUENCE "SEQ_AIR_MONITORING_LOG_ID"
    START WITH 1
    NOCACHE
    NOCYCLE;

CREATE TABLE air_monitoring_logs (
    "ID" INTEGER DEFAULT SEQ_AIR_MONITORING_LOG_ID.nextval,
    "DEVICE_ID" INTEGER,
    "FROM_EMAIL" VARCHAR2(50) DEFAULT 'sensor@airsensorcompany.com',
    "TO_EMAIL" VARCHAR2(50) DEFAULT 'monitor@airsensormonitor.com',
    "SUBJECT" VARCHAR2(50),
    "MESSAGE" VARCHAR2(255),
    "TIME" TIMESTAMP
    );

ALTER TABLE air_monitoring_logs
ADD CONSTRAINT pk_air_monitoring_logs PRIMARY KEY ("ID");