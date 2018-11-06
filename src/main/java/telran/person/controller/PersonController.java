package telran.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import telran.person.domain.Address;
import telran.person.domain.Person;
import telran.person.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@PostMapping("/person/")
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable int id) {
		return personService.getPerson(id);
	}
	
	@DeleteMapping("/person/{id}")
	public boolean removePerson(@PathVariable int id) {
		return personService.removePerson(id);
	}

	@PutMapping("/person/{id}")
	public boolean updateAddress(@PathVariable int id, @RequestBody Address address){
		return personService.updateAddress(id, address);
	}

	@GetMapping("/persons/{minAge}/{maxAge}/")
	public Iterable<Person> getPersonByAge(@PathVariable int minAge, @PathVariable int maxAge){
		return personService.getPersonByAge(minAge, maxAge);
	}

	@GetMapping("/persons/{city}/")
	public Iterable<Person> getPersonByCity(@PathVariable String city){
		return personService.getPersonByCity(city);
	}

	@GetMapping("/persons/")
	public Iterable<Person> getAll(){
		return personService.getAllPersons();
	}


	@GetMapping("/persons/employee/{minSalary}/{maxSalary}/")
	public Iterable<Person> getEmployeeBySalary(@PathVariable int minSalary, @PathVariable int maxSalary) {
		return personService.getEmployeeBySalary(minSalary, maxSalary);
	}

	@GetMapping("/persons/child/{kindergarten}/")
	public Iterable<Person> getChildByKindergarten(@PathVariable String kindergarten){
		return personService.getChildByKindergarten(kindergarten);
	}

}
