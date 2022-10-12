package com.shankarBojanki.repository;

import com.shankarBojanki.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);




    @Query(value = "select count(id) from employee",nativeQuery = true)
    List<Employee> countEmployees();






    @Query("select e from Employee e where e.first_name in :first_names")
    List<Employee> findByfirstName(@Param("first_names") String first_name);

    @Query("select e from Employee e where e.last_name in :last_names")
    List<Employee> findBylastName(@Param("last_names") String last_name);

    @Query("select e from Employee e where e.salery in :saleries")
    List<Employee> findBySalary(@Param("saleries")  int salery);


    //byexperience

    @Query(value = "select  timestampdiff(YEAR,JoinedOn,current_date) as years from employee where",nativeQuery = true)
    List<Employee> findByExperience();


    @Query(value = "update Employee e set e.first_name =?1,e.last_name =?2,e.email =?3,e.gender =?4,e.salery =?5,e.role =?6 where e.id=?7",nativeQuery = true)
    List<Employee> updateEmployee(String first_name, String last_name, String email, String gender,int salery,String role,Long id);


    @Modifying
    @Query(value = "delete  from Employee e  where e.id=:?1", nativeQuery = true)
    void deleteEmployeeById(Long id) ;


    @Query("select e from Employee e where e.email in :emails")
    List<Employee> findByEmails(@Param("emails") List<String> emails);




}
