package com.khalil.marketplace.courier.dhl;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Client for the DHL location API. In production this calls DHL over HTTP;
 * here it returns fixed data so the project runs offline.
 */
@Component
public class DhlLocationClient {

    private static final List<DhlPackstation> STATIONS = List.of(
            new DhlPackstation("PS-101", "Warschauer Str. 70", "10243", "Berlin", 52.5060, 13.4490, true),
            new DhlPackstation("PS-102", "Alexanderplatz 3", "10178", "Berlin", 52.5219, 13.4132, true),
            new DhlPackstation("PS-103", "Kottbusser Tor 1", "10999", "Berlin", 52.4990, 13.4180, false),
            new DhlPackstation("PS-104", "Bayerstr. 10", "80335", "München", 48.1402, 11.5600, true));

    /** All known stations. The real API is paged; we keep it simple. */
    public List<DhlPackstation> findAll() {
        return STATIONS;
    }
}
