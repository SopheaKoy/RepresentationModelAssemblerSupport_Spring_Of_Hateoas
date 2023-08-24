package co.cstad.hwspringhateoas.api.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
@Component
public class Student extends RepresentationModel<Student> {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uuid;

    private String name;

    private String gender;

}
