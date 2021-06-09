package com.bestcodingspot.SpringBoot.service;

import com.bestcodingspot.SpringBoot.entity.Department;
import com.bestcodingspot.SpringBoot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

   public Department findById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId);

    public Department updateById(Long deparmentId, Department department);

    Department getByName(String departmentName);
}
