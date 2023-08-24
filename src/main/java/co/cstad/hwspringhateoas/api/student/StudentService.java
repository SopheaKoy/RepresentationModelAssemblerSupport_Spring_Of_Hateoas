package co.cstad.hwspringhateoas.api.student;

import co.cstad.hwspringhateoas.api.student.web.StudentDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface StudentService {

    CollectionModel<?> getAll();

    StudentDTO getByUuid(String uuid);
}
