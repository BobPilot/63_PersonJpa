package telran.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.person.dao.PersonRepository;
import telran.person.domain.Address;
import telran.person.domain.Person;

import java.time.LocalDate;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository repository;

	@Override
	public void addPerson(Person person) {
		repository.save(person);

	}

	@Override
	public Person getPerson(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public boolean removePerson(int id) {
		Person person = repository.findById(id).orElse(null);
		if (person == null) {
			return false;
		}
		repository.delete(person);
		return true;
	}

	@Override
	public boolean updateAddress(int id, Address address) {
		Person person = repository.findById(id).orElse(null);
		if(person != null){

			Address personAddress = person.getAddress();
			if(address.getCity() != null){
				personAddress.setCity(address.getCity());
			}
			if(address.getStreet() != null){
				personAddress.setStreet(address.getStreet());
			}
			if(address.getBuilding() != 0){
				personAddress.setBuilding(address.getBuilding());
			}

			person.setAddress(personAddress);
			repository.save(person);
			return true;
		}
		return false;
	}

	@Override
	public Iterable<Person> getPersonByAge(int minAge, int maxAge) {

		LocalDate from = LocalDate.now().minusYears(maxAge);
		LocalDate to = LocalDate.now().minusYears(minAge);

		return repository.findByBirthDateBetween(from, to);
	}

	@Override
	public Iterable<Person> getPersonByCity(String city) {
		return repository.findByAddressCity(city);
	}

	@Override
	public Iterable<Person> getAllPersons() {
		return repository.findAll();
	}


	@Override
	public Iterable<Person> getEmployeeBySalary(int minSalary, int maxSalary) {
		return repository.getEmployeeBySalary(minSalary, maxSalary);
	}

	@Override
	public Iterable<Person> getChildByKindergarten(String kindergarten) {
		return repository.getChildByKindergarten(kindergarten);
	}


}
