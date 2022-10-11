package com.shankarBojanki.repository;

import com.shankarBojanki.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);




    @Query("select e from Employee e where e.first_name in :first_names")
    List<Employee> findByfirstName(@Param("first_names") String first_name);

    @Query("select e from Employee e where e.last_name in :last_names")
    List<Employee> findBylastName(@Param("last_names") String last_name);

    @Query("select e from Employee e where e.salery in :saleries")
    List<Employee> findBySalary(@Param("saleries")  int salery);


    //byexperience

    @Query("select e from Employee e where e.email in :emails")
    List<Employee> findByEmails(@Param("emails") List<String> emails);



    @Query( "SELECT count(e) FROM Employee e where e.id=id")
    List<Employee> findCountofAllEmployees();



     @Query("select e from  Employee e")
     List<Employee>findAllEmployees();


}
