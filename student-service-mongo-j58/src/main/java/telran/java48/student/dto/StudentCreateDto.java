package telran.java48.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentCreateDto {
	Long id;// если поле равно налл, то значит оно не было передано, а если равно 0 то передали ноль
	String name;
	String password;
}
