package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguages;

public interface ProgrammingLanguagesService {
	
	void add(ProgrammingLanguages programmingLanguages);
	void delete(int id);
	List<ProgrammingLanguages> list();
	ProgrammingLanguages getbyId(int id);
	void update(int id,String name);
	
}
