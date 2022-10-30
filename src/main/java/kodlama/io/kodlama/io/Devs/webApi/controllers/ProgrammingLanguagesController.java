package kodlama.io.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.Devs.business.abstracts.ProgrammingLanguagesService;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguages;

@RestController
@RequestMapping("api/test")
public class ProgrammingLanguagesController {
	ProgrammingLanguagesService programmingLanguagesService;

	public ProgrammingLanguagesController(ProgrammingLanguagesService programmingLanguagesService) {
		this.programmingLanguagesService = programmingLanguagesService;
	}
	@GetMapping("listall")
	public List<ProgrammingLanguages> listAll(){
		return programmingLanguagesService.list();
	}
	@GetMapping("getbyId/{id}")
	public ProgrammingLanguages getbyId(@PathVariable() int id) {
		return programmingLanguagesService.getbyId(id);
	}
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguages programmingLanguages) {
		programmingLanguagesService.add(programmingLanguages);
	}
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable int id) {
		programmingLanguagesService.delete(id);
	}
	@PutMapping("update/{id}/{name}")
	public void update(@PathVariable int id, @PathVariable String name) {
		programmingLanguagesService.update(id,name);;
	}
	
	
}
