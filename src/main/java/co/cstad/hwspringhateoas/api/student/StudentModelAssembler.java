package co.cstad.hwspringhateoas.api.student;

import co.cstad.hwspringhateoas.api.student.web.StudentController;
import co.cstad.hwspringhateoas.api.student.web.StudentDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class StudentModelAssembler extends RepresentationModelAssemblerSupport<Student, StudentDTO> {
    public StudentModelAssembler() {
        super(StudentController.class, StudentDTO.class);
    }

    @Override
    public StudentDTO toModel(Student entity) {

        StudentDTO dto = instantiateModel(entity);
        dto.setUuid(entity.getUuid());
        dto.setName(entity.getName());
        dto.setGender(entity.getGender());

        dto.add(linkTo(
                methodOn(StudentController.class)
                        .findAll())
                .withSelfRel());

        if (entity.getName().equals("sa")) {
            dto.add(linkTo(
                    methodOn(StudentController.class)
                            .findById(entity.getUuid())).withSelfRel());
        }

        return dto;
    }

    @Override
    public CollectionModel<StudentDTO> toCollectionModel(Iterable<? extends Student> entities) {
        CollectionModel<StudentDTO> dtoList = super.toCollectionModel(entities);
        dtoList.add(linkTo(methodOn(StudentController.class).findAll()).withSelfRel());
        return dtoList;
    }
}
