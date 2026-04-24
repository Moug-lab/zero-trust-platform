package com.security.detection.controller;

import com.security.detection.model.RequestPayload;
import com.security.detection.service.DetectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detect")
public class DetectionController {

    private final DetectionService service;

    public DetectionController(DetectionService service) {
        this.service = service;
    }

    @PostMapping
    public String detect(@RequestBody RequestPayload request) {
        return service.analyze(request.getData());
    }

    @GetMapping("/test")
    public String test() {
        return "WORKING";
    }
}