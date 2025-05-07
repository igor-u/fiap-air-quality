package br.com.fiap.airquality.repository.device;

import br.com.fiap.airquality.domain.device.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface DeviceRepository extends MongoRepository<Device, UUID> {

    Device findByModel(String model);

}
