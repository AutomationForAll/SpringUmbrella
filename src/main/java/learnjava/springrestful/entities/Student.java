package learnjava.springrestful.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rollNo;
	@Column(name = "StudentName", columnDefinition = "varchar(50) default 'noName'")
	@NotBlank(message = "Name can not be blank")
	private String name;
	@Column(name = "StudentAge", columnDefinition = "integer default 0")
	@NotNull(message = "Age can not be blank")
	private int age;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Address_id")
	private Address address;

	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date createdAt;
	@UpdateTimestamp
	private Date updatedAt;


}
