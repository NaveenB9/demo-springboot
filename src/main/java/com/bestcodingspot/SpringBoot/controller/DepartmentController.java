package com.bestcodingspot.SpringBoot.controller;

import com.bestcodingspot.SpringBoot.entity.Department;
import com.bestcodingspot.SpringBoot.error.DepartmentNotFoundException;
import com.bestcodingspot.SpringBoot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger Log = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department) {
        Log.info("Inside SaveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/fetch")
    public List<Department> fetchDepartmentList() {
        Log.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/findById/{id}")
        public Department findById (@PathVariable ("id") Long departmentId) throws DepartmentNotFoundException {
        Log.info("Inside findById of DepartmentController");
            return departmentService.findById(departmentId);
        }

    @DeleteMapping("/deleteById/{id}")
   public String deleteDepartmentById(@PathVariable ("id") Long departmentId){
        Log.info("Inside deleteById of DepartmentController");
    departmentService.deleteDepartmentById(departmentId);
    return "Record By Deleted Succesfully ";
    }
    @PutMapping("/updateById/{id}")
    public Department updateDepartmentById(@PathVariable ("id") Long deparmentId,@RequestBody Department department){
        Log.info("Inside updateById of DepartmentController");
        return departmentService.updateById(deparmentId,department);
    }
    @GetMapping("/getByName/{name}")
    public Department getByName(@PathVariable ("name") String departmentName){
        Log.info("Inside getByName of DepartmentController");
        return departmentService.getByName(departmentName);
    }

}




