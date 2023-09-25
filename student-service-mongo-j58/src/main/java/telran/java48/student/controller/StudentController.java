package telran.java48.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import telran.java48.student.dto.ScoreDto;
import telran.java48.student.dto.StudentCreateDto;
import telran.java48.student.dto.StudentDto;
import telran.java48.student.dto.StudentUpdateDto;
import telran.java48.student.service.StudentService;

@RestController
@RequiredArgsConstructor
public class StudentController {
	@Autowired // скажем что при старте присвой переменной studentService значение обьекта 
	final StudentService studentService; //если полю ставиш файнал то поставь @RequiredArgsConstructor

	@PostMapping("/student")
	public Boolean addStudent(@RequestBody StudentCreateDto studentCreateDto) {
		return studentService.addStudent(studentCreateDto);
	}

	@GetMapping("/student/{studentId}")
	public StudentDto findStudent(@PathVariable("studentId") Long id) {
		return studentService.findStudent(id);
	}

	@DeleteMapping("/student/{id}")
	public StudentDto removeStudent(@PathVariable Long id) {
		return studentService.removeStudent(id);
	}

	@PutMapping("/student/{id}")
	public StudentCreateDto updateStudent(@PathVariable Long id, @RequestBody StudentUpdateDto studentUpdateDto) {
		return studentService.updateStudent(id, studentUpdateDto);
	}

	@PutMapping("/score/student/{id}")
	public Boolean addScore(@PathVariable Long id, @RequestBody ScoreDto scoreDto) {
		return studentService.addScore(id, scoreDto);
	}

	@GetMapping("/students/name/{name}")
	public List<StudentDto> findStudentsByName(@PathVariable String name) {
		return studentService.findStudentsByName(name);
	}

	@PostMapping("/quantity/students")
	public Long getStudentsNamesQuantity(@RequestBody List<String> names) {
		return studentService.getStudentsNamesQuantity(names);
	}

	@GetMapping("/students/exam/{exam}/minscore/{minScore}")
	public List<StudentDto> getStudentsByExamMinScore(@PathVariable String exam, @PathVariable Integer minScore) {
		return studentService.getStudentsByExamMinScore(exam, minScore);
	}

}
