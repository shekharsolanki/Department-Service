package in.raghavmadhav.Department.Service.repository;

import in.raghavmadhav.Department.Service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentNameIgnoreCase(String departmentName);
}