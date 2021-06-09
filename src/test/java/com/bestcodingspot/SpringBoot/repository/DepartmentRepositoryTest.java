package com.bestcodingspot.SpringBoot.repository;

import com.bestcodingspot.SpringBoot.entity.Department;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Civil Engineering")
                .departmentAddress("Nizamabad")
                .departmentCode("CE-09")
                .build();
        testEntityManager.persist(department);
    }
    @org.junit.jupiter.api.Test
    public  void whenGetById_ThenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Civil Engineering");
    }
}