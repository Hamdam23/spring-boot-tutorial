package net.javaguides.springboot.service.service.impl;

import net.javaguides.springboot.exeption.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if(existingEmployee.isPresent()){
            existingEmployee.get().setFirstName(employee.getFirstName());
            existingEmployee.get().setLastName(employee.getLastName());
            existingEmployee.get().setEmail(employee.getEmail());

            employeeRepository.save(existingEmployee.get());
        }else{
            throw new ResourceNotFoundException("Employee", "Id", id);
        }

        return existingEmployee.get();
    }

    @Override
    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }
}
