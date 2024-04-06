package in.raghavmadhav.Department.Service.service;

import in.raghavmadhav.Department.Service.entity.Department;
import in.raghavmadhav.Department.Service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        log.info("Inside addDepartment of DepartmentServiceImpl");
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAllDepartments() {
        log.info("Inside findAllDepartments of DepartmentServiceImpl");
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById of DepartmentServiceImpl");
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public Department findDepartmentByName(String departmentName) {
        log.info("Inside findDepartmentByName of DepartmentServiceImpl");
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        log.info("Inside deleteDepartmentById of DepartmentServiceImpl");
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentUsingPut(Long departmentId, Department department) {

        log.info("Inside updateDepartmentUsingPut of DepartmentServiceImpl");

        Department department1 = null;
        if (departmentRepository.findById(departmentId).isPresent()) {
            department1 = departmentRepository.findById(departmentId).get();
            if (Objects.nonNull(department.getDepartmentName()) &&
                    !"".equalsIgnoreCase(department.getDepartmentName()))
                department1.setDepartmentName(department.getDepartmentName());
            if (Objects.nonNull(department.getDepartmentAddress()) &&
                    !"".equalsIgnoreCase(department.getDepartmentAddress()))
                department1.setDepartmentAddress(department.getDepartmentAddress());
            if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
                department1.setDepartmentCode(department.getDepartmentCode());
            return departmentRepository.save(department1);
        }
        return null;
    }
}