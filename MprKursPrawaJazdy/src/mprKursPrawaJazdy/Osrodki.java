package mprKursPrawaJazdy;

import java.util.ArrayList;
import java.util.List;

	public class Osrodki {


		private String Nazwa;
		private List<Kursant> kursanci= new ArrayList<Kursant>();
		private List<Kurs> kursy= new ArrayList<Kurs>();


		public Osrodki(String nazwa, List<Kursant> kursanci, List<Kurs> kursy) {

			this.Nazwa = nazwa;
			this.kursanci = kursanci;
			this.kursy = kursy;
		}

		public Osrodki(String nazwa) {
			super();
			this.Nazwa = nazwa;
			this.kursanci = new ArrayList<Kursant>();
			this.kursy = new ArrayList<Kurs>();
		}

		public String getNazwa() {
			return Nazwa;
		}

		public void setNazwisko(String nazwa) {
			Nazwa = nazwa;
		}

		public List<Kursant> getKursanci() {
			return kursanci;
		}

		public void setKursanci(List<Kursant> kursanci) {
			this.kursanci = kursanci;
		}

		public List<Kurs> getKursy() {
			return kursy;
		}

		public void setKursy(List<Kurs> kursy) {
			this.kursy = kursy;
		}

		public void removeKursant(String nazwisko) {
			
			kursanci.remove(searchKursant(nazwisko));
			}
		
			
		public void removeKursant(int iD_numer) {

			kursanci.remove(searchKursant(iD_numer));
			
		}
		
		public void removeKursant(int iD_numer, String nazwisko) {

			kursanci.remove(searchKursant(iD_numer, nazwisko));
			
		}

		public void removeKurs(String nazwa) {

			kursy.remove(searchKurs(nazwa));

		}
		
		public void removeKurs(int iD_kurs) {

			kursy.remove(searchKurs(iD_kurs));

		}
		
		public void removeKurs(int iD_kurs, String nazwa) {

			kursy.remove(searchKurs(iD_kurs, nazwa));

		}

		public void addKursant (int iD_numer, String nazwisko){
			kursanci.add(new Kursant(iD_numer, nazwisko));

		}

		public void addKurs (int iD_kurs, String nazwa){
			kursy.add(new Kurs(iD_kurs, nazwa));

		}

		public Kursant searchKursant(String nazwisko) {

			for (Kursant kursant : kursanci) {
				if (kursant.getNazwisko().equals(nazwisko))
					return kursant;
			}
			throw new IllegalStateException("Brak kursanta o nazwisku: " + nazwisko);
			
		}
		
		public Kursant searchKursant(int iD_numer) {

			for (Kursant kursant : kursanci) {
				if (kursant.getID_numer().equals(iD_numer))
					return kursant;
			}
			throw new IllegalStateException("Brak kursanta z ID: " + iD_numer);

		}
		
		public Kursant searchKursant(int iD_numer, String nazwisko) {

			for (Kursant kursant : kursanci) {
				if (kursant.getID_numer().equals(iD_numer) & kursant.getNazwisko().equals(nazwisko))
					return kursant;
			}
			throw new IllegalStateException("Brak kursanta z ID: " + iD_numer+ " i Nazwiskiem: "+nazwisko);

		}
		
		

		public Kurs searchKurs(String nazwa){

			for (Kurs kurs : kursy) {
				if (kurs.getNazwa().equals(nazwa))
					return kurs;
			}
			throw new IllegalStateException("Brak kursu o nazwie: "+nazwa);
		}
		
		public Kurs searchKurs(int iD_kurs){

			for (Kurs kurs : kursy) {
				if (kurs.getID_kurs().equals(iD_kurs))
					return kurs;
			}
			throw new IllegalStateException("Brak kursu z ID: " + iD_kurs);
		}
		
		
		public Kurs searchKurs(int iD_kurs, String nazwa) {

			for (Kurs kurs : kursy) {
				if (kurs.getID_kurs().equals(iD_kurs) & kurs.getNazwa().equals(nazwa))
					return kurs;
			}
			throw new IllegalStateException("Brak kursu z ID: " + iD_kurs+ " o nazwie: "+nazwa);

		}
		
		

		public void printKursanci(){
			
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Lista kursantow:");
			for(Kursant kursant: kursanci){
				kursant.printKursant();
			}
		}
		
		
		public void editKursant_Nazwisko(int id_numer, String nazwisko, String new_nazwisko) {
			kursanci.set(kursanci.indexOf(searchKursant(nazwisko)), new Kursant(id_numer, new_nazwisko));
			}

		public void editKursant_Id_numer(int iD_numer, String nazwisko, int new_iD_numer) {
			kursanci.set(kursanci.indexOf(searchKursant(iD_numer)), new Kursant(new_iD_numer, nazwisko));
			}
		
		public void editKursant_Id_numer_Nazwisko(int iD_numer, String nazwisko, int new_iD_numer, String new_nazwisko) {
			kursanci.set(kursanci.indexOf(searchKursant(iD_numer, nazwisko)), new Kursant(new_iD_numer, new_nazwisko));
			}
		
		
		
		public void editKurs_Nazwa(int id_kurs, String nazwa, String new_nazwa) {
			kursy.set(kursy.indexOf(searchKurs(nazwa)), new Kurs(id_kurs, new_nazwa));
			}

		public void editKurs_ID_kurs(int id_kurs, String nazwa, int new_iD_kurs) {
			kursy.set(kursy.indexOf(searchKurs(id_kurs)), new Kurs(new_iD_kurs, nazwa));
			}
				
		public void editKurs_Id_kurs_Nazwa(int iD_kurs, String nazwa, int new_iD_kurs, String new_nazwa) {
			kursy.set(kursy.indexOf(searchKurs(iD_kurs, nazwa)), new Kurs(new_iD_kurs, new_nazwa));
			}
		
	

		public void printKursy(){
			
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Lista kursow:");
			for(Kurs kurs: kursy){
				kurs.printKurs();
			}
		}

		public void printAll(){
			
			System.out.println("---------------------------------------------------------------------");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Osrodek: "+getNazwa()+". Lista kursantow :");

			for(Kursant kursant: kursanci){
				kursant.printKursant();
			}

			System.out.println("Osrodek: "+getNazwa()+". Lista kursow :");

			for(Kurs kurs: kursy){
				kurs.printKurs();
			}
		}

	}