package us.jcedeno.stclock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/all")
    public ResponseEntity<Iterable<Shift>> getAllShifts() {
        return ResponseEntity.ok(timeClockService.getAllShifts());
    }

    @PostMapping("/clockIn/{id}")
    public ResponseEntity<Shift> clockIn(@PathVariable String id) {
        return ResponseEntity.ok(timeClockService.clockIn(id));
    }

    @PostMapping("/clockOut/{id}")
    public ResponseEntity<Shift> clockOut(@PathVariable String id) {
        return ResponseEntity.ok(timeClockService.clockOut(id));
    }

}
