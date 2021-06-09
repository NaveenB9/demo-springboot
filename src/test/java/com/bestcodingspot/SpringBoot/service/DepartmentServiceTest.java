package com.bestcodingspot.SpringBoot.service;

import com.bestcodingspot.SpringBoot.entity.Department;
import com.bestcodingspot.SpringBoot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("CSE")
                .departmentAddress("HYD")
                .departmentCode("CSE-09")
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CSE"))
                .thenReturn(department);
    }
    @Test
    void getByName() {
        String departmentName = "CSE";
        Department found = departmentService.getByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}