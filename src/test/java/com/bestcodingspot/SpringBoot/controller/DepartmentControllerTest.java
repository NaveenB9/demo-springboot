package com.bestcodingspot.SpringBoot.controller;

import com.bestcodingspot.SpringBoot.entity.Department;
import com.bestcodingspot.SpringBoot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() {

        department = Department.builder()
                .departmentAddress("Nizamabad")
                .departmentCode("CSE-07")
                .departmentName("CSE")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws  Exception{
        Department inputDepartment = Department.builder()
                .departmentAddress("Nizamabad")
                .departmentCode("CSE-07")
                .departmentName("CSE")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"CSE\",\n" +
                        "    \"departmentAddress\":\"Nizamabad\",\n" +
                        "      \"departmentCode\":\"CSE-07\"\n" +
                        "  }")).andExpect(status().isOk());
    }

    @Test
    void findById() throws  Exception{

        Mockito.when(departmentService.findById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments//findById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").
                        value(department.getDepartmentName()));
    }
}