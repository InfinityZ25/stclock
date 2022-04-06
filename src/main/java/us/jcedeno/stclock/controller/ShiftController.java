package us.jcedeno.stclock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import us.jcedeno.stclock.model.Shift;
import us.jcedeno.stclock.service.TimeClockService;

@RestController
@RequestMapping(value = "/api/shift")
public class ShiftController {
    private final TimeClockService timeClockService;

    public ShiftController(TimeClockService timeClockService) {
        this.timeClockService = timeClockService;
    }

    @PostMapping("/clockIn")
    public ResponseEntity<Shift> clockIn(@RequestParam String id) {
        return ResponseEntity.ok(timeClockService.clockIn(id));
    }

    @PostMapping("/clockOut")
    public ResponseEntity<Shift> clockOut(@RequestParam String id) {
        return ResponseEntity.ok(timeClockService.clockOut(id));
    }

}
