package co.cstad.hwspringhateoas.api.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student , Integer> {

    Optional<Student> findByUuid(String uuid);

}
