package telran.person.service;

import telran.person.domain.Address;
import telran.person.domain.Person;

public interface PersonService {
	
	void addPerson(Person person);
	
	Person getPerson(int id);
	
	boolean removePerson(int id);
	
	boolean updateAddress(int id, Address address);
	
	Iterable<Person> getPersonByAge(int minAge, int maxAge);
	
	Iterable<Person> getPersonByCity(String city);

	Iterable<Person> getAllPersons();
	
	Iterable<Person> getEmployeeBySalary(int minSalary, int maxSalary);

	Iterable<Person> getChildByKindergarten(String kindergarten);
	
}
