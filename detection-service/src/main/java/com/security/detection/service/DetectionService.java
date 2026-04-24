package com.security.detection.service;

import org.springframework.stereotype.Service;

@Service
public class DetectionService {

    public String analyze(String payload) {

        if (payload == null) return "EMPTY";

        String p = payload.toLowerCase();

        if (p.contains("drop table") || p.contains("union select"))
            return "SQL_INJECTION";

        if (p.contains("<script>"))
            return "XSS_ATTACK";

        return "SAFE";
    }
}