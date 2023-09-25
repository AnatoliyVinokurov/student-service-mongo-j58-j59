package telran.java48.student.service;

import java.util.List;

import telran.java48.student.dto.ScoreDto;
import telran.java48.student.dto.StudentCreateDto;
import telran.java48.student.dto.StudentDto;
import telran.java48.student.dto.StudentUpdateDto;

public interface StudentService {
	Boolean addStudent(StudentCreateDto studentCreateDto);

	StudentDto findStudent(Long id);

	StudentDto removeStudent(Long id);

	StudentCreateDto updateStudent(Long id, StudentUpdateDto studentUpdateDto);

	Boolean addScore(Long id, ScoreDto scoreDto);
	
	List<StudentDto> findStudentsByName(String name);
	
	Long getStudentsNamesQuantity(List<String> names);
	
	List<StudentDto> getStudentsByExamMinScore(String exam, Integer minScore);
	
}
