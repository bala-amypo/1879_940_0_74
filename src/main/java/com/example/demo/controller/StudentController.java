package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;



import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Studentsdata")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/postdata")
    public ResponseEntity<Student> postdata(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(
                studentService.saveStudent(student),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/getdata/{id}")
    public Student getdata(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/updatedata/{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody Student student){
    return studentService.updatedata(id,student);
    }

    @DeleteMapping("/deletedata/{id}")
    public ResponseEntity<String> deletedata(@PathVariable Long id) {
    studentService.deletedata(id);
    return ResponseEntity.ok("Student deleted successfully");
}


}
