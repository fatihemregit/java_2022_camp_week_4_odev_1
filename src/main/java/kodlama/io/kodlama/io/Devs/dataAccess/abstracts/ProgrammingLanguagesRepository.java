package kodlama.io.kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguages;

public interface ProgrammingLanguagesRepository {
	
	void add(ProgrammingLanguages programmingLanguages);
	void delete(int id);
	List<ProgrammingLanguages> list();
	ProgrammingLanguages getbyId(int id);
	void update(int id,String name);
}
