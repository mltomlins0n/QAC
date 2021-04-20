package com.qa.controllers;

import com.qa.models.TeamRecord;
import com.qa.repositories.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamControllerTest {

    @InjectMocks
    private TeamController teamController;

    @Mock
    private TeamRepository teamRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDriversPage() {
        assertThat(this.restTemplate
                .getForObject("http://35.228.126.86:" + port + "/teams", String.class))
                .isNotNull();
    }

    @Test
    public void testListAllRecords() {
        List<TeamRecord> teamList = new ArrayList<>();
        TeamRecord teamRecord = new TeamRecord();
        TeamRecord teamRecord2 = new TeamRecord();

        teamRecord.setName("Test team");
        teamRecord2.setName("Test team 2");

        teamList.add(teamRecord);
        teamList.add(teamRecord2);

        when(teamRepository.findAll()).thenReturn(teamList);

        for (TeamRecord record : teamList) {
            assertThat(teamList).contains(record);
        }
    }

    @Test
    public void testGetRecord() {
        TeamRecord teamRecord = new TeamRecord();
        teamRecord.setName("One team");

        when(teamRepository.findOne(1L)).thenReturn(teamRecord);
        teamController.getRecord(1L);
    }

    @Test
    public void testAddRecord() {
        TeamRecord teamRecord = new TeamRecord();
        teamRecord.setName("Added team");

        when(teamRepository.saveAndFlush(teamRecord)).thenReturn(teamRecord);
        teamController.addRecord(teamRecord);
    }

    @Test
    public void testUpdateRecord() {
        TeamRecord teamRecord = new TeamRecord();
        teamRecord.setName("Team to update");
        assertThat(teamRecord.getName()).contains("Team to update");
        teamRecord.setName("Updated name");

        when(teamRepository.findOne(1L)).thenReturn(teamRecord);
        teamController.updateRecord(1L, teamRecord);
        when(teamRepository.saveAndFlush(teamRecord)).thenReturn(teamRecord);

        assertThat(teamRecord.getName()).contains("Updated name");
    }

    @Test
    public void testDeleteRecord() {
        TeamRecord teamRecord = new TeamRecord();
        teamRecord.setId(1L);
        teamController.deleteRecord(1L);

        when(!teamRepository.exists(1L)).thenReturn(true);

    }
}