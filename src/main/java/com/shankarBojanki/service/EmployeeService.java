package com.shankarBojanki.service;



import com.shankarBojanki.entity.Employee;
import com.shankarBojanki.repository.EmployeeRepository;
import com.shankarBojanki.utility.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Pair<List<Employee>, List<Employee>> saveEmployee(MultipartFile file) {

        try {
            List<Employee> list = CSVHelper.csvToEmployee(file.getInputStream());
            List<String> emails = list.stream().map(e -> e.getEmail()).collect(Collectors.toList());

            List<Employee> existingEmployees = employeeRepository.findByEmails(emails);

            HashSet<String> existingEmployeeEmails = (HashSet<String>) existingEmployees.stream().map(e -> e.getEmail())
                    .collect(Collectors.toSet());
            List<Employee> EmployeeToInsert = new ArrayList<Employee>();
            list.stream().forEach(u -> {
                if (!existingEmployeeEmails.contains(u.getEmail())) {
                    EmployeeToInsert.add(u);
                }
            });

            employeeRepository.saveAll(EmployeeToInsert);

            Pair<List<Employee>, List<Employee>> result = Pair.of(existingEmployees, EmployeeToInsert);

            return result;

        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }

    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> getAllWEmail() {

        return (List<Employee>) employeeRepository.findByEmail("email");
    }

    public Page<Employee> findUsersWithPagination(int pageNumber, int pageSize,String field) {
        Page<Employee> employeesPage = employeeRepository.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)));
        return employeesPage;
    }

    public List<Employee> findEmployeesWithSorting(String field) {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }


    public List<Employee> findyearsOfExperience(String field){
        return employeeRepository.findByExperience();
    }






    // role 1
    public int avgTeamManagerSalary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Team Manager")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 2
    public int avgAccountantSalary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Accountant")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 3
    public int avgSalersManagerSalary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Salers Manager")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 4
    public int avgSE3Salary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SE3")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 5
    public int avgTechLeadSalary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Tech Lead")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 6
    public int avgSE2Salary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SE2")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 7
    public int avgSE1Salary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SE1")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 8
    public int avgSystemAdminSalary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("System Admin")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 9
    public int avgProjectManagerSalary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Project Manager")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 10
    public int avgSSE1Salary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SSE1")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }

    // role 11
    public int avgSSE2Salary() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SSE2")) {
            } else {
                sum += employees.getSalery();
                count++;
            }
            ;
        }
        avg = sum / count;
        return avg;

    }


    // Different roles count in csv file

    // role 1
    public int CountTeamManager() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Team Manager")) {
            } else {
                count++;
            }
            ;
        }
        return count;

    }

    // role 2
    public int CountAccountant() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Accountant")) {
            } else {
                count++;
            }
            ;
        }
        return count;

    }

    // role 3
    public int CountSalersManager() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Salers Manager")) {
            } else {
                count++;
            }
            ;
        }
        return count;

    }

    // role 4
    public int CountSE3() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SE3")) {
            } else {
                count++;
            }
            ;
        }

        return count;

    }

    // role 5
    public int CountTechLead() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Tech Lead")) {
            } else {
                count++;
            }
            ;
        }

        return count;

    }

    // role 6
    public int CountSE2() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SE2")) {
            } else {
                count++;
            }
            ;
        }

        return count;

    }

    // role 7
    public int CountSE1() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SE1")) {
            } else {
                count++;
            }
            ;
        }

        return count;

    }

    // role 8
    public int CountSystemAdmin() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("System Admin")) {
            } else {
                count++;
            }
            ;
        }

        return count;

    }

    // role 9
    public int CountProjectManager() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Project Manager")) {
            } else {
                count++;
            }
            ;
        }

        return count;

    }

    // role 10
    public int CountSSE1() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SSE1")) {
            } else {
                count++;
            }
            ;
        }

        return count;

    }

    // role 11
    public int CountSSE2() {
        List<Employee> employeeList = employeeRepository.findAll();
        int sum = 0, count = 0, avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SSE2")) {
            } else {
                count++;
            }
            ;
        }

        return count;

    }


    public Employee updateEmployee(Long id, Employee employee) {
        Employee empDB = employeeRepository.findById(id).get();

        if(Objects.nonNull(employee.getFirst_name()) &&
                !"".equalsIgnoreCase(employee.getFirst_name())) {
            empDB.setFirst_name(employee.getFirst_name());
        }

        if(Objects.nonNull(employee.getLast_name()) &&
                !"".equalsIgnoreCase(employee.getLast_name())) {
            empDB.setLast_name(employee.getLast_name());
        }


        if(Objects.nonNull(employee.getEmail()) &&
                !"".equalsIgnoreCase(employee.getEmail())) {
            empDB.setEmail(employee.getEmail());
        }


        if(Objects.nonNull(employee.getGender()) &&
                !"".equalsIgnoreCase(employee.getGender())) {
            empDB.setGender(employee.getGender());
        }


        if(Objects.nonNull(employee.getJoined_on()) &&
                !"".equalsIgnoreCase(String.valueOf(employee.getJoined_on()))) {
            empDB.setJoined_on(employee.getJoined_on());
        }


        if(Objects.nonNull(employee.getSalery()) &&
                !"".equalsIgnoreCase(String.valueOf(employee.getSalery()))) {
            empDB.setSalery(employee.getSalery());
        }


        if(Objects.nonNull(employee.getRole()) &&
                !"".equalsIgnoreCase(employee.getRole())) {
            empDB.setRole(employee.getRole());
        }



        return employeeRepository.save(empDB);
    }


    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }



}

