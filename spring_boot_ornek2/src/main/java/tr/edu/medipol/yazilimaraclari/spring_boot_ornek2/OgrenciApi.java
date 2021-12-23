package tr.edu.medipol.yazilimaraclari.spring_boot_ornek2;

import java.util.*;

import org.springframework.web.bind.annotation.*;

// Rest apiler uygulamalar arası bilgi alışverişi/entegrasyon için kullanılan bir standarttır.
@RestController
@RequestMapping("/ogrenci")
public class OgrenciApi {
	 
	@GetMapping("/listele") // Get request | http://localhost:8080/ogrenci/listele
	public List<Ogrenci> listele() {
		
		return OgrenciVeriServisi.ogrencileriGetir();
	}
	
	@PostMapping("/ekle")
	public Ogrenci ekle(@RequestBody Ogrenci ogrenci) {
		OgrenciVeriServisi.ogrenciEkle(ogrenci);
		return ogrenci;
	}
	
	// Ogrenciekle'nin get versiyonu
	
	@GetMapping("/ekle2")
	public Ogrenci ogrenciEkle(@RequestParam String isim, @RequestParam String numara) {
		Ogrenci ogrenci = new Ogrenci(isim, numara);
		OgrenciVeriServisi.ogrenciEkle(ogrenci);
		return ogrenci;
	}
	
	
	
}
