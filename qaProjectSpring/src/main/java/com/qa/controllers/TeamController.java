package com.qa.controllers;

import java.util.List;
import com.qa.models.TeamRecord;
import com.qa.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TeamController {

    @Autowired
    private TeamRepository repo;

    @RequestMapping(value = "teams", method = RequestMethod.GET)
    public List<TeamRecord> listAllRecords() {
        return repo.findAll();
    }

    @RequestMapping(value = "teams/{id}", method = RequestMethod.GET)
    public TeamRecord getRecord(@PathVariable Long id){
        return repo.findOne(id);
    }

    @RequestMapping(value = "teams", method = RequestMethod.POST)
    public TeamRecord addRecord(@RequestBody TeamRecord teamRecord){
        return repo.saveAndFlush(teamRecord);
    }

    @Transactional
    @RequestMapping(value = "teams/{id}", method = RequestMethod.POST)
    public TeamRecord updateRecord(@PathVariable Long id, @RequestBody TeamRecord teamRecord) {
        TeamRecord teamToUpdate = repo.findOne(id);
        teamToUpdate.updateTeam(teamRecord);
        repo.saveAndFlush(teamToUpdate);
        return teamToUpdate;
    }

    @RequestMapping(value = "teams/{id}", method = RequestMethod.DELETE)
    public TeamRecord deleteRecord(@PathVariable Long id) {
        TeamRecord teamToDelete = repo.findOne(id);
        repo.delete(teamToDelete);
        return teamToDelete;
    }
}
