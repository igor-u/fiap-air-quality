package br.com.fiap.airquality;

import br.com.fiap.airquality.model.device.Device;
import br.com.fiap.airquality.model.device.DeviceStatus;
import br.com.fiap.airquality.model.device.impl.AirQualitySensor;
import br.com.fiap.airquality.model.device.impl.GasLeakDetector;
import br.com.fiap.airquality.model.device.impl.OzoneMonitoringInstrument;
import br.com.fiap.airquality.model.monitor.AirMonitoringStation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class TesteApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("air-quality");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        AirMonitoringStation airMonitoringStation = new AirMonitoringStation();

        AirQualitySensor airQualitySensor = new AirQualitySensor();
        airQualitySensor.setModel("Modelo123");
        airQualitySensor.setStatus(DeviceStatus.ACTIVE);
        airQualitySensor.setAqi(100.);
        airQualitySensor.setEco2Ppm(12.);

        GasLeakDetector gasLeakDetector = new GasLeakDetector();
        gasLeakDetector.setModel("Modelo123");
        gasLeakDetector.setStatus(DeviceStatus.INACTIVE);
        gasLeakDetector.setCh4Ppm(100.);
        gasLeakDetector.setHcPpm(12.);

        OzoneMonitoringInstrument ozoneMonitoringInstrument = new OzoneMonitoringInstrument();
        ozoneMonitoringInstrument.setModel("Modelo123");
        ozoneMonitoringInstrument.setStatus(DeviceStatus.HEATING_UP);
        ozoneMonitoringInstrument.setBro2x10e15moleculesPerCm2(100.);
        ozoneMonitoringInstrument.setOrbitHeightKm(12.);

        entityManager.persist(airMonitoringStation);
        entityManager.persist(airQualitySensor);
        entityManager.persist(gasLeakDetector);
        entityManager.persist(ozoneMonitoringInstrument);

        airMonitoringStation.getDevices().add(airQualitySensor);
        airMonitoringStation.getDevices().add(gasLeakDetector);

        transaction.commit();

        List<Device> devices = entityManager.createQuery("SELECT p FROM devices p", Device.class).getResultList();

        System.out.println("Devices:");
        for (Device p : devices) {
            System.out.println("ID: " + p.getId() + ", Model: " + p.getModel());
            if (p instanceof AirQualitySensor) {
                System.out.println("AQI: " + ((AirQualitySensor) p).getAqi());
            } else if (p instanceof GasLeakDetector)
            {
                System.out.println("HC_PPM: " + ((GasLeakDetector) p).getHcPpm());
            }
        }

        entityManager.close();
        entityManagerFactory.close();

    }

}
