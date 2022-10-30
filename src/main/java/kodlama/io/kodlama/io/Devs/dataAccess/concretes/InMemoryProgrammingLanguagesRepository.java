package kodlama.io.kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguagesRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.ProgrammingLanguages;



/*
  	MY Notes
  	update fonksiyonu listId(listenin index) ile değil ögenin ıd si ile çalışabilecek hale getirelecek(Yapıldı)
	add fonksiyonunda sıkıntı yok elleme.()
	listall fonksiyonunda sıkıntı yok elleme.
	getbyId fonksiyonunda sıkıntı yok elleme
	delete fonksiyonu ilk çalışmada hata veriyor ama verilen id ye sahip ögeyi başarıyla  siliyor. daha sonraki çalışmalarında düzgün (hata vermiyor ve ögeyi başarıyla siliyor) çalışıyor.(kendiliğinden çözüldü)


 */

@Repository
public class InMemoryProgrammingLanguagesRepository implements ProgrammingLanguagesRepository{
	
	List<ProgrammingLanguages> programmingLanguageslist;
	
	
	
	@Autowired
	public InMemoryProgrammingLanguagesRepository() {
		programmingLanguageslist = new ArrayList<ProgrammingLanguages>();
		programmingLanguageslist.add(new ProgrammingLanguages(1,"C#"));
		programmingLanguageslist.add(new ProgrammingLanguages(2,"Java"));
		programmingLanguageslist.add(new ProgrammingLanguages(3,"Python"));
		
	}



	@Override
	public void add(ProgrammingLanguages programmingLanguages) {
		programmingLanguageslist.add(programmingLanguages);
		
	}


	@Override
	public void delete(int id) {
		
		
		for(ProgrammingLanguages programmingLanguages : programmingLanguageslist) {
			if(programmingLanguages.getId() == id) {
				programmingLanguageslist.remove(programmingLanguages);
			}
		}
		
		//programmingLanguageslist.remove(programmingLanguages);
		
	}



	@Override
	public List<ProgrammingLanguages> list() {
		return programmingLanguageslist;
	}



	@Override
	public ProgrammingLanguages getbyId(int id) {
		for (ProgrammingLanguages programmingLanguagesa : programmingLanguageslist) {
			if(programmingLanguagesa.getId() == id) {
				return programmingLanguagesa;
			}
		}
		return null;
	}



	@Override
	public void update(int id,String name) {
		
		//for döngüsü ile ögenin kaçıncı yerde olduğunu bul sonra set komutu ile ögeyi değiştir(yaptım)
		//değişecek ögeyi class olarak alırsak id değişebiliyor o yüzden ilerki aşamada classın özelliklerini parametre olarak alıp class ı içerde tanımla(yaptım)
		int a = 0;
		for (ProgrammingLanguages programmingLanguages : programmingLanguageslist) {
			a = a + 1;
			if(programmingLanguages.getId() == id) {
				programmingLanguageslist.set(a - 1, new ProgrammingLanguages(id, name));
			}
		}
		
		//programmingLanguageslist.set(listId, programmingLanguages);
		
	}
	
	
	

}
