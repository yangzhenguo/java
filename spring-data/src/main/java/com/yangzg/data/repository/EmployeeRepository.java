package com.yangzg.data.repository;

import com.yangzg.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/12/7.
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = String.class)
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> getByUid(String uid);

    List<Employee> findAllByBirthdayBefore(LocalDate now);
}
