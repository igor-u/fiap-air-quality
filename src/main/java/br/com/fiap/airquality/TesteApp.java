package br.com.fiap.airquality;

import br.com.fiap.airquality.model.device.impl.AirQualitySensor;
import br.com.fiap.airquality.model.monitor.AirMonitoringStation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TesteApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("air-quality");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        AirMonitoringStation airMonitoringStation = new AirMonitoringStation();
        entityManager.persist(airMonitoringStation);

        AirQualitySensor airQualitySensor = new AirQualitySensor();
        airQualitySensor.setAqi(100.);

        airMonitoringStation.getDevices().add(airQualitySensor);

        entityManager.persist(airQualitySensor);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();

    }

}
