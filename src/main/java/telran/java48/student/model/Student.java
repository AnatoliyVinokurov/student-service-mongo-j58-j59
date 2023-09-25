package telran.java48.student.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Document(collection = "students")
public class Student {
	long id;
	@Setter
	String name;
	@Setter
	String password;
	Map<String, Integer> scores = new HashMap<>();

	public Student(long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public boolean addScore(String exam, int score) {
		return scores.put(exam, score) == null;
	}

}
