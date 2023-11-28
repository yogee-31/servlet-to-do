package dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
public class Userdto {
	@Id
	String name;
	@Column(unique = true)
	String email;
	String password;
	long mobile;
	String gender;
	LocalDate date;
	int age;
	

}
