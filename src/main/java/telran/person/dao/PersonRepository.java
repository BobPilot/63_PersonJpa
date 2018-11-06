package telran.person.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import telran.person.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	List<Person> findByBirthDateBetween(LocalDate from, LocalDate to);

	List<Person> findByAddressCity(String city);

	@Query("select e from Employee e where e.salary between :minSalary and :maxSalary")
	Iterable<Person> getEmployeeBySalary(@Param("minSalary") int minSalary, @Param("maxSalary") int maxSalary);

	@Query("select ch from Child ch where ch.kindergarten = :kindergarten")
	Iterable<Person> getChildByKindergarten(@Param("kindergarten") String kindergarten);

}
