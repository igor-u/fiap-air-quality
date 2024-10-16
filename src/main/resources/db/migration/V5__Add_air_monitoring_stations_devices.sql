CREATE TABLE air_monitoring_stations_devices (
    "AIR_MONITORING_STATION_ID" INTEGER NOT NULL,
    "DEVICES_ID" INTEGER NOT NULL
    );

ALTER TABLE air_monitoring_stations_devices
ADD (
CONSTRAINT pk_air_monitoring_stations_devices PRIMARY KEY ("AIR_MONITORING_STATION_ID", "DEVICES_ID"),
CONSTRAINT unique_device_id UNIQUE ("DEVICES_ID"),
CONSTRAINT fk_air_monitoring_stations_devices_to_air_monitoring_stations FOREIGN KEY ("AIR_MONITORING_STATION_ID") REFERENCES air_monitoring_stations("ID"),
CONSTRAINT fk_air_monitoring_stations_devices_to_devices FOREIGN KEY ("DEVICES_ID") REFERENCES devices("ID")
);