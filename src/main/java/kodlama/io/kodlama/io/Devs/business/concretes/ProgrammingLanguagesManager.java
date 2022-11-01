package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguagesService;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguagesRepository;

import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguages;


@Service
public class ProgrammingLanguagesManager implements ProgrammingLanguagesService{
	
	
	private ProgrammingLanguagesRepository programmingLanguagesRepository;
	
	@Autowired
	public ProgrammingLanguagesManager(ProgrammingLanguagesRepository programmingLanguagesRepository) {
		
		this.programmingLanguagesRepository = programmingLanguagesRepository;
	}

	@Override
	public void add(ProgrammingLanguages programmingLanguages) {
		
		if(!(programmingLanguages.getName().equals("") || programmingLanguages.getName().equals(null))) {
			String programmingLanguagesName = programmingLanguages.getName();
			if(isnameexist(programmingLanguagesRepository.list(), programmingLanguagesName)) {
				return;
			}
			else {
				programmingLanguagesRepository.add(programmingLanguages);
			}
		}
		else {
			return;
		}
		
		
		
	}
	
	public boolean isnameexist(List<ProgrammingLanguages> programmingLanguageslist,String name) {
		for (ProgrammingLanguages programmingLanguages : programmingLanguageslist) {
			if(programmingLanguages.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
		
	}
	
	@Override
	public void delete(int id) {
		programmingLanguagesRepository.delete(id);
		
	}

	@Override
	public List<ProgrammingLanguages> list() {
		return programmingLanguagesRepository.list();
	}

	@Override
	public ProgrammingLanguages getbyId(int id) {
		return programmingLanguagesRepository.getbyId(id);
	}

	@Override
	public void update(int id,String name) {
		programmingLanguagesRepository.update(id,name);
	}
	
	
	
}
