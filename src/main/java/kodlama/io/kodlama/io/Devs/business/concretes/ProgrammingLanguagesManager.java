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
		String programmingLanguagesName = programmingLanguages.getName();
		if(!programmingLanguagesName.isEmpty()) {
			List<ProgrammingLanguages> programmingLanguagesList = programmingLanguagesRepository.list();
			for (ProgrammingLanguages programmingLanguages2 : programmingLanguagesList) {
				if(!programmingLanguages2.getName().equalsIgnoreCase(programmingLanguagesName)) {
					programmingLanguagesRepository.add(programmingLanguages);
					break;
				}
			}
		}else {
			return;
		}
		
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
