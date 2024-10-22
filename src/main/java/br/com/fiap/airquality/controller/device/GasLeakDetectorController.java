package br.com.fiap.airquality.controller.device;

import br.com.fiap.airquality.model.device.impl.GasLeakDetector;
import br.com.fiap.airquality.service.device.GasLeakDetectorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("air_quality")
public class GasLeakDetectorController {

    private final GasLeakDetectorService gasLeakDetectorService;

    @Autowired
    public GasLeakDetectorController(GasLeakDetectorService gasLeakDetectorService) {
        this.gasLeakDetectorService = gasLeakDetectorService;
    }

    @PostMapping("/gas_leak_detector")
    @Transactional
    public GasLeakDetector createDevice(@RequestBody GasLeakDetector gasLeakDetector) {
        return gasLeakDetectorService.createDevice(gasLeakDetector);
    }

}
