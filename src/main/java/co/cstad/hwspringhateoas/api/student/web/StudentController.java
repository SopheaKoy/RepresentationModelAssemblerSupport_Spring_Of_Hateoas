package co.cstad.hwspringhateoas.api.student.web;

import co.cstad.hwspringhateoas.api.student.Student;
import co.cstad.hwspringhateoas.api.student.StudentRepository;
import co.cstad.hwspringhateoas.api.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final Student student;

    @GetMapping
    public CollectionModel<?> findAll(){

        return CollectionModel.of(studentService.getAll());

    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findById(@PathVariable String uuid){

        return EntityModel.of(studentService.getByUuid(uuid));

    }


}
