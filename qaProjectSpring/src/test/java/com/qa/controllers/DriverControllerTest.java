package com.qa.controllers;


import com.qa.models.DriverRecord;
import com.qa.repositories.DriverRepository;
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
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DriverControllerTest {

    @InjectMocks
    private DriverController driverController;

    @Mock
    private DriverRepository driverRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDriversPage() {
        assertThat(this.restTemplate
                .getForObject("http://35.228.126.86:" + port + "/drivers", String.class))
                .isNotNull();
    }

    @Test
    public void testListAllRecords() {
        List<DriverRecord> driverList = new ArrayList<>();
        DriverRecord driverRecord = new DriverRecord();
        DriverRecord driverRecord2 = new DriverRecord();

        driverRecord.setName("Test driver");
        driverRecord2.setName("Second test driver");

        driverList.add(driverRecord);
        driverList.add(driverRecord2);

        when(driverRepository.findAll()).thenReturn(driverList);

        for (DriverRecord record : driverList) {
            assertThat(driverList).contains(record);
        }
    }

    @Test
    public void testGetRecord() {
        DriverRecord driverRecord = new DriverRecord();
        driverRecord.setName("One driver");

        when(driverRepository.findOne(1L)).thenReturn(driverRecord);
        driverController.getRecord(1L);
    }

    @Test
    public void testAddRecord() {
        DriverRecord driverRecord = new DriverRecord();
        driverRecord.setName("Added driver");

        when(driverRepository.saveAndFlush(driverRecord)).thenReturn(driverRecord);
        driverController.addRecord(driverRecord);
    }

    @Test
    public void testUpdateRecord() {
        DriverRecord driverRecord = new DriverRecord();
        driverRecord.setName("Driver to update");
        assertThat(driverRecord.getName()).contains("Driver to update");
        driverRecord.setName("Updated name");

        when(driverRepository.findOne(1L)).thenReturn(driverRecord);
        driverController.updateRecord(1L, driverRecord);
        when(driverRepository.saveAndFlush(driverRecord)).thenReturn(driverRecord);

        assertThat(driverRecord.getName()).contains("Updated name");
    }

    @Test
    public void testDeleteRecord() {
        DriverRecord driverRecord = new DriverRecord();
        driverRecord.setId(1L);
        driverController.deleteRecord(1L);
        when(!driverRepository.exists(1L)).thenReturn(true);
    }
}
