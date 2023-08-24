package co.cstad.hwspringhateoas.api.student.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StudentDTO extends RepresentationModel<StudentDTO> {

    private String uuid;

    private String name;

    private String gender;

}
