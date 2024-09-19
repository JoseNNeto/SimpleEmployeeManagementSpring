package personalprojects.employermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import personalprojects.employermanagement.dto.EmployeeDto;
import personalprojects.employermanagement.mapper.EmployeeMapper;
import personalprojects.employermanagement.model.Employee;
import personalprojects.employermanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return EmployeeMapper.toEmployeeDto(employee);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public EmployeeDto getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return EmployeeMapper.toEmployeeDto(employee);
    }

    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        return EmployeeMapper.toEmployeeDto(employeeRepository.save(employee));
    }

    public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee == null) {
            return null;
        }
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        
        return EmployeeMapper.toEmployeeDto(employeeRepository.save(employee));
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
