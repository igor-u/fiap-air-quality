package br.com.fiap.airquality.controller;

import br.com.fiap.airquality.model.device.impl.OzoneMonitoringInstrument;
import br.com.fiap.airquality.service.OzoneMonitoringInstrumentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("air_quality")
public class OzoneMonitoringInstrumentController {

    private final OzoneMonitoringInstrumentService ozoneMonitoringInstrumentService;

    @Autowired
    public OzoneMonitoringInstrumentController(OzoneMonitoringInstrumentService ozoneMonitoringInstrumentService) {
        this.ozoneMonitoringInstrumentService = ozoneMonitoringInstrumentService;
    }

    @PostMapping("/ozone_monitoring_instrument")
    @Transactional
    public OzoneMonitoringInstrument createDevice(@RequestBody OzoneMonitoringInstrument ozoneMonitoringInstrument) {
        return ozoneMonitoringInstrumentService.createDevice(ozoneMonitoringInstrument);
    }

}
