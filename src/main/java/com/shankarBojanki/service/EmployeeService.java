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
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;



    public Pair<List<Employee>,List<Employee>> saveEmployee(MultipartFile file){

        try {
            List<Employee> list = CSVHelper.csvToEmployee(file.getInputStream());
            List<String> emails = list.stream().map(e -> e.getEmail()).collect(Collectors.toList());

            List<Employee> existingEmployees = employeeRepository.findByEmails(emails);

            HashSet<String> existingEmployeeEmails = (HashSet<String>) existingEmployees.stream().map(e -> e.getEmail()).collect(Collectors.toSet());
            List<Employee> EmployeeToInsert = new ArrayList<Employee>();
            list.stream().forEach(u -> {
                if (!existingEmployeeEmails.contains(u.getEmail())) {
                    EmployeeToInsert.add(u);
                }
            });


            employeeRepository.saveAll(EmployeeToInsert);


            Pair<List<Employee>, List<Employee>> result = Pair.of(existingEmployees, EmployeeToInsert);

            return result;

        }catch (IOException e){
            throw new RuntimeException("fail to store csv data: "+e.getMessage());
        }

    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public List<Employee> getAllWEmail(){

        return (List<Employee>) employeeRepository.findByEmail("email");
    }




    public Page<Employee>findUsersWithPagination(int  pageNumber,int pageSize){
        Page<Employee> employeesPage=employeeRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return employeesPage;
    }




    public List<Employee> findEmployeesWithSorting(String field){
        return  employeeRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }




    //role 1
    public int avgTeamManagerSalary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Team Manager")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }




    //role 2
    public int avgAccountantSalary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Accountant")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }



    //role 3
    public int avgSalersManagerSalary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Salers Manager")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }

    //role 4
    public int avgSE3Salary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SE3")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }


    //role 5
    public int avgTechLeadSalary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Tech Lead")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }


    //role 6
    public int avgSE2Salary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SE2")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }



    //role 7
    public int avgSE1Salary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SE1")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }


    //role 8
    public int avgSystemAdminSalary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("System Admin")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }


    //role 9
    public int avgProjectManagerSalary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("Project Manager")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }



    //role 10
    public  int avgSSE1Salary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SSE1")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }


    //role 11
    public int avgSSE2Salary(){
        List<Employee> employeeList=employeeRepository.findAll();
        int sum =0, count=0,avg;

        for (Employee employees : employeeList) {
            String str = employees.getRole();
            if (str != null && !str.equals("SSE2")){
            }else {
                sum+=employees.getSalery();
                count++;
            };
        }
        avg =sum/count;
        return avg;

    }







}














