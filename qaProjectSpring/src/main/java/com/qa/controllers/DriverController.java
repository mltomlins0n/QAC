package com.qa.controllers;

import java.util.List;
import com.qa.models.DriverRecord;
import com.qa.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverRepository repo;

    @RequestMapping(value = "drivers", method = RequestMethod.GET)
    public List<DriverRecord> listAllRecords() { return repo.findAll(); }

    @RequestMapping(value = "drivers/{id}", method = RequestMethod.GET)
    public DriverRecord getRecord(@PathVariable Long id) {
        return repo.findOne(id);
    }

    @RequestMapping(value = "drivers", method = RequestMethod.POST)
    public DriverRecord addRecord(@RequestBody DriverRecord driverRecord) {
        return repo.saveAndFlush(driverRecord);
    }

    @Transactional
    @RequestMapping(value = "drivers/{id}", method = RequestMethod.POST)
    public DriverRecord updateRecord(@PathVariable Long id, @RequestBody DriverRecord driverRecord) {
        DriverRecord driverToUpdate = repo.findOne(id);
        driverToUpdate.updateDriver(driverRecord);
        repo.saveAndFlush(driverToUpdate);
        return driverToUpdate;
    }

    @RequestMapping(value = "drivers/{id}", method = RequestMethod.DELETE)
    public DriverRecord deleteRecord(@PathVariable Long id) {
        DriverRecord driverToDelete = repo.findOne(id);
        repo.delete(driverToDelete);
        return driverToDelete;
    }
}
