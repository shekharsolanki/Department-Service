package in.raghavmadhav.Department.Service.service;

import in.raghavmadhav.Department.Service.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department addDepartment(Department department);

    List<Department> findAllDepartments();

    Department findDepartmentById(Long departmentId);

    Department findDepartmentByName(String departmentName);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentUsingPut(Long departmentId, Department department);
}
