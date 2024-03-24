package com.janvi.crudrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.janvi.crudrest.services.EmployeeServices;
import com.janvi.crudrest.entities.Employee;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices ems;

    @GetMapping("/empall")
    public List<Employee> search() {
        return ems.searchAll();
    }

    @GetMapping("/empsearch/{empno}")
    public Employee find(@PathVariable int empno) {
        return ems.search(empno);
    }

    @PostMapping("/empadd")
    public Employee adEmployee(@RequestBody Employee empad) {
        return ems.AddEmp(empad);
    }

    @PutMapping("/update")
    public String increment(@RequestParam int empno, @RequestParam float salary) {
        String st = ems.Update(empno, salary);
        return st;
    }

    @DeleteMapping("/dlt")
    public String dlt(@RequestParam int empno) {
        String st = ems.close(empno);
        return st;
    }
}
