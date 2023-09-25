package telran.java48.student.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java48.student.dao.StudentRepository;
import telran.java48.student.dto.ScoreDto;
import telran.java48.student.dto.StudentCreateDto;
import telran.java48.student.dto.StudentDto;
import telran.java48.student.dto.StudentUpdateDto;
import telran.java48.student.model.Student;

//@Component //скажем что при старте создай обьект класса StudentServiceImpl и положи себе в контекст
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	
	final StudentRepository studentRepository;

	@Override
	public Boolean addStudent(StudentCreateDto studentCreateDto) {
		if (studentRepository.findById(studentCreateDto.getId()) != null) {
			return false;
		}
		Student student = new Student(studentCreateDto.getId(), studentCreateDto.getName(),
				studentCreateDto.getPassword());
		studentRepository.save(student);
		return true;
	}

	@Override
	public StudentDto findStudent(Long id) {
		Student student = studentRepository.findById(id);
		return new StudentDto(id, student.getName(), student.getScores());//если нет то вернуть 404 нужно будет реализовать
	}

	@Override
	public StudentDto removeStudent(Long id) {
		Student student = studentRepository.deleteById(id);
		return new StudentDto(id, student.getName(), student.getScores());
	}

	@Override
	public StudentCreateDto updateStudent(Long id, StudentUpdateDto studentUpdateDto) {
		Student student = studentRepository.findById(id);
		if(studentUpdateDto.getName() != null) {
			student.setName(studentUpdateDto.getName());
		}
		if(studentUpdateDto.getPassword() != null) {
			student.setPassword(studentUpdateDto.getPassword());
		}
		return new StudentCreateDto(id, student.getName(), student.getPassword());
	}

	@Override
	public Boolean addScore(Long id, ScoreDto scoreDto) {
		Student student = studentRepository.findById(id);
		return student.addScore(scoreDto.getExamName(), scoreDto.getScore());
	}

	@Override
	public List<StudentDto> findStudentsByName(String name) {
		return studentRepository.findAll()
				.stream()
				.filter(s -> name.equalsIgnoreCase(s.getName()))
				.map(s -> new StudentDto(s.getId(), s.getName(), s.getScores()))
				.collect(Collectors.toList());
	}

	@Override
	public Long getStudentsNamesQuantity(List<String> names) {
		return studentRepository.findAll()
				.stream()
				.filter(s -> names.contains(s.getName().toLowerCase()))
				.count();
	}

	@Override
	public List<StudentDto> getStudentsByExamMinScore(String exam, Integer minScore) {
		return studentRepository.findAll()
				.stream()
				.filter(s -> s.getScores().containsKey(exam) && s.getScores().get(exam) >= minScore)
				.map(s -> new StudentDto(s.getId(), s.getName(), s.getScores()))
				.collect(Collectors.toList());
	}

}
