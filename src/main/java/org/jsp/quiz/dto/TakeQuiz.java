package org.jsp.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TakeQuiz {
	private int id;
	private String title;
	private String a;
	private String b;
	private String c;
	private String d;

}
