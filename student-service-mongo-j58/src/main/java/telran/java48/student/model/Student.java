package telran.java48.student.model;

import java.util.HashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Student {
	Long id;
	@Setter
	String name;
	@Setter
	String password;
	Map<String, Integer> scores = new HashMap<>();
	public Student(Long id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public boolean addScore(String exam, int score) {
		return scores.put(exam, score) == null; //пут если такая оценка есть то заменит, если нет то добавит
	}
	
}
