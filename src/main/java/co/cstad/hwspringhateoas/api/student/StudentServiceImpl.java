package co.cstad.hwspringhateoas.api.student;

import co.cstad.hwspringhateoas.api.student.web.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final Student student;
    private final StudentModelAssembler studentModelAssembler;


    @Override

    public CollectionModel<?> getAll() {

        List<Student> studentList = studentRepository.findAll();

        return studentModelAssembler.toCollectionModel(studentList);
    }

    @Override
    public StudentDTO getByUuid(String uuid) {
        return studentModelAssembler.toModel(studentRepository.findByUuid(uuid).orElseThrow());
    }
}
