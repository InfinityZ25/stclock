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

    @GetMapping("/")
    public ResponseEntity<Iterable<Shift>> getAllShifts() {
        return ResponseEntity.ok(timeClockService.getAllShifts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shift> getById(@PathVariable String id) {
        return ResponseEntity.ok(timeClockService.getShiftById(id));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Iterable<Shift>> getEmployeesShifts(@PathVariable String id) {
        return ResponseEntity.ok(timeClockService.getEmployeeShifts(id));
    }

    @PostMapping("/in/{id}")
    public ResponseEntity<Shift> clockIn(@PathVariable String id) {
        return ResponseEntity.ok(timeClockService.clockIn(id));
    }

    @PostMapping("/out/{id}")
    public ResponseEntity<Shift> clockOut(@PathVariable String id) {
        return ResponseEntity.ok(timeClockService.clockOut(id));
    }

}
