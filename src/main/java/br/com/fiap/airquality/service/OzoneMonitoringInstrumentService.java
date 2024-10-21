package br.com.fiap.airquality.service;

import br.com.fiap.airquality.model.device.impl.OzoneMonitoringInstrument;
import br.com.fiap.airquality.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OzoneMonitoringInstrumentService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public OzoneMonitoringInstrumentService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public OzoneMonitoringInstrument createDevice(OzoneMonitoringInstrument ozoneMonitoringInstrument) {
        return deviceRepository.save(ozoneMonitoringInstrument);
    }

}
