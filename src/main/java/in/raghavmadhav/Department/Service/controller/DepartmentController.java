package in.raghavmadhav.Department.Service.controller;

import in.raghavmadhav.Department.Service.entity.Department;
import in.raghavmadhav.Department.Service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department) {
        log.info("Inside addDepartment of DepartmentController");
        return departmentService.addDepartment(department);
    }

    @GetMapping("/")
    public List<Department> fetchAllDepartments() {
        log.info("Inside fetchAllDepartments of DepartmentController");
        return departmentService.findAllDepartments();
    }

    @GetMapping("/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/names/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        log.info("Inside fetchDepartmentByName of DepartmentController");
        return departmentService.findDepartmentByName(departmentName);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully !";
    }

    @PutMapping("/{id}")
    public Department updateDepartmentUsingPut(@PathVariable("id") Long departmentId,
                                               @RequestBody Department department) {
        log.info("Inside updateDepartmentUsingPut of DepartmentController");
        return departmentService.updateDepartmentUsingPut(departmentId, department);
    }

    @PatchMapping("/{id}")
    public Department updateDepartmentUsingPatch(@PathVariable("id") Long departmentId,
                                                 @RequestBody Department department) {
        log.info("Inside updateDepartmentUsingPatch of DepartmentController");
        return departmentService.updateDepartmentUsingPatch(departmentId, department);
    }
}