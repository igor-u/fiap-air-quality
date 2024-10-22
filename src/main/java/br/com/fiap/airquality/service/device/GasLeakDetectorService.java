package br.com.fiap.airquality.service.device;

import br.com.fiap.airquality.model.device.impl.GasLeakDetector;
import br.com.fiap.airquality.repository.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GasLeakDetectorService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public GasLeakDetectorService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public GasLeakDetector createDevice(GasLeakDetector gasLeakDetector) {
        return deviceRepository.save(gasLeakDetector);
    }

}
