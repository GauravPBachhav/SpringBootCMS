package in.gw.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.gw.main.entities.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long>
{

}
