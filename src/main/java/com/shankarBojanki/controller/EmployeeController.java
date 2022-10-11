package com.shankarBojanki.controller;

import com.shankarBojanki.APIResponse.APIResponse;
import com.shankarBojanki.dto.ResponseData;
import com.shankarBojanki.entity.Employee;
import com.shankarBojanki.repository.EmployeeRepository;
import com.shankarBojanki.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/file/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, Employee employee) {

        try {

            Pair<List<Employee>, List<Employee>> processedInfo = employeeService.saveEmployee(file);

            ResponseData response = new ResponseData();
            response.setStatus(true);
            response.getMessages().add("success  :" + file.getOriginalFilename());
            response.setData(processedInfo);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.out.println(e);
            ResponseData response = new ResponseData();
            response.setStatus(false);
            response.getMessages().add("can't upload file :" + file.getOriginalFilename());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }

    }

    @GetMapping("/employee")
    public List<Employee> findAllUsers() {

        List<Employee> employees = employeeService.getAll();
        return  employees;
    }

    @GetMapping("/emails")
    public List<Employee> findAllEmail() {

        List<Employee> employees = employeeService.getAllWEmail();
        return employees;
    }

    @GetMapping("/pagination")
    private APIResponse<Page<Employee>> getEmployeesWithPagination(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
        Page<Employee> employeesWithPagination = employeeService.findUsersWithPagination(pageNumber, pageSize);
        return new APIResponse<>(employeesWithPagination.getSize(), employeesWithPagination);
    }


    @GetMapping("/sorting/{field}")
    private List<Employee> getEmployeesWithSorting(@PathVariable String field){
        List<Employee> alEmployeeList=employeeService.findEmployeesWithSorting(field);
        return alEmployeeList;


    }

    @GetMapping("/employee/first_name")
    public ResponseEntity<List<Employee>> getEmployeeswithfirstName(@RequestParam String first_name){
           return new ResponseEntity<List<Employee>>(employeeRepository.findByfirstName(first_name),HttpStatus.OK);
    }

    @GetMapping("/employee/last_name")
    public ResponseEntity<List<Employee>> getEmployeeswithlastName(@RequestParam String last_name){
        return new ResponseEntity<List<Employee>>(employeeRepository.findBylastName(last_name),HttpStatus.OK);
    }


    @GetMapping("/employee/salery")
    public ResponseEntity<List<Employee>> getEmployeewithSalary(@RequestParam int salery){
        return new ResponseEntity<List<Employee>>(employeeRepository.findBySalary(salery),HttpStatus.OK);
    }

    @GetMapping("/employeescount")
    public ResponseEntity<List<Employee>> getEmployeeCount(){
        return new ResponseEntity<List<Employee>>(employeeRepository.findCountofAllEmployees(),HttpStatus.OK);
    }




    @GetMapping("/avgTeamManagerSalary")
    public int getTeamManagersalary() {
        int avgTeamManagerSalaryMsalary =employeeService.avgSE1Salary();
        return avgTeamManagerSalaryMsalary;
    }





    @GetMapping("AllRolesAverageSalary")
    public String AllRolesAverageSalary(){
        return "Team manager salary "+employeeService.avgTeamManagerSalary() + "\n" +
                "Accountant salary "+employeeService.avgAccountantSalary()+ "\n" +
                "Salers Manager salary "+employeeService.avgSalersManagerSalary()+ "\n" +
                "SE3 salary "+employeeService.avgSE3Salary()+ "\n" +
                "Tech Lead salary "+employeeService.avgTechLeadSalary()+ "\n" +
                "SE2 salary "+employeeService.avgSE2Salary()+ "\n" +
                "SE1 salary "+employeeService.avgSE1Salary()+ "\n" +
                "System Admin salary "+employeeService.avgSystemAdminSalary()+ "\n" +
                "Project Manager salary "+employeeService.avgProjectManagerSalary()+ "\n" +
                "SSE1 salary "+employeeService.avgSSE1Salary()+ "\n" +
                "SSE2 salary "+employeeService.avgSSE2Salary();
    }










}






//id,first_name,last_name,email,gender,joined_on,salery,role