package br.com.fiap.airquality.mongo;

import br.com.fiap.airquality.domain.UuidIdentifiedEntityEventListener;
import br.com.fiap.airquality.domain.device.Device;
import br.com.fiap.airquality.domain.device.DeviceStatus;
import br.com.fiap.airquality.domain.device.impl.AirQualitySensor;
import br.com.fiap.airquality.domain.device.impl.GasLeakDetector;
import br.com.fiap.airquality.domain.device.impl.OzoneMonitoringInstrument;
import br.com.fiap.airquality.domain.monitor.AirMonitoringStation;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import br.com.fiap.airquality.repository.monitor.AirMonitoringStationRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataMongoTest
@Import(UuidIdentifiedEntityEventListener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MongoRepositoryTest {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private AirMonitoringStationRepository airMonitoringStationRepository;

    @Container
    @ServiceConnection
    private static final MongoDBContainer mongoDBContainer;

    static {
        mongoDBContainer = new MongoDBContainer("mongo:latest");
        mongoDBContainer.start();
    }

    @Test
    void assertThatMongoDbContainerIsCreated() {
        assertThat(mongoDBContainer.isCreated()).isTrue();
        assertThat(mongoDBContainer.isRunning()).isTrue();
    }

    @Test
    void assertThatAirQualitySensorIsCreated() {
        Device airQualitySensor = AirQualitySensor.builder()
                .model("SensorPro")
                .status(DeviceStatus.INACTIVE)
                .build();

        deviceRepository.save(airQualitySensor);

        Device retrievedAirQualitySensor = deviceRepository.findByModel("SensorPro");

        assertThat(airQualitySensor).isEqualTo(retrievedAirQualitySensor);

    }

    @Test
    void assertThatOzoneMonitoringInstrumentIsCreated() {
        Device ozoneMonitoringInstrument = OzoneMonitoringInstrument.builder()
                .model("AirGuard")
                .status(DeviceStatus.INACTIVE)
                .build();

        deviceRepository.save(ozoneMonitoringInstrument);

        Device retrievedOzoneMonitoringInstrument = deviceRepository.findByModel("AirGuard");

        assertThat(ozoneMonitoringInstrument).isEqualTo(retrievedOzoneMonitoringInstrument);

    }

    @Test
    void assertThatGasLeakDetectorIsCreated() {
        Device gasLeakDetector = GasLeakDetector.builder()
                .model("SafeSpace")
                .status(DeviceStatus.INACTIVE)
                .build();

        deviceRepository.save(gasLeakDetector);

        Device retrievedGasLeakDetector = deviceRepository.findByModel("SafeSpace");

        assertThat(gasLeakDetector).isEqualTo(retrievedGasLeakDetector);

    }

    @Test
    void assertThatThreeDevicesHaveBeenCreated() {

        Set<Device> devices = new HashSet<>(deviceRepository.findAll());

        AirMonitoringStation airMonitoringStation = AirMonitoringStation.builder()
                .country("Brazil")
                .city("São Paulo")
                .devices(devices)
                .build();

        airMonitoringStationRepository.save(airMonitoringStation);

        AirMonitoringStation retrievedAirMonitoringStation = airMonitoringStationRepository.findByCountry("Brazil");

        assertThat(airMonitoringStation).isEqualTo(retrievedAirMonitoringStation);
        assertThat(retrievedAirMonitoringStation.getDevices().size()).isEqualTo(3);
    }

    @AfterAll
    @Test
    void assertThatDocumentsAreErased() {
        deviceRepository.deleteAll();
        airMonitoringStationRepository.deleteAll();

        assertThat(deviceRepository.count()).isEqualTo(0);
        assertThat(airMonitoringStationRepository.count()).isEqualTo(0);

    }

}
