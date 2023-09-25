package telran.java48.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentCreateDto {
	Long id;
	String name;
	String password;
}
