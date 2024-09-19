package personalprojects.employermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import personalprojects.employermanagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
    
}
