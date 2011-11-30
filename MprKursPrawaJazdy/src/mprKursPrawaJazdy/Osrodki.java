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

		public void setNazwa(String nazwa) {
			Nazwa = nazwa;
		}

////////////////////////////////////////KURS////////////////////////////////////////
		
		public List<Kurs> getKursy() {
			return kursy;
		}
		
		public void addKurs (int iD_kurs, String nazwa){
			kursy.add(new Kurs(iD_kurs, nazwa));

		}
		
		public void addWieleKursow(List<Kurs> kursDoDodania)
		{
			kursy.addAll(kursDoDodania);
		}

		public void setKursy(List<Kurs> kursy) {
			this.kursy = kursy;
		}

		public void removeWieleKursow(List<Kurs> kursDoUsuniecia)
		{
			kursy.removeAll(kursDoUsuniecia);
		}
		
		public List<Kurs> findKursPoNazwie(String nazwa)
		{
			List<Kurs> foundedKursy= new ArrayList<Kurs>();
			for(Kurs kurs : kursy)
			{
				if(kurs.getNazwa().equals(nazwa))
					foundedKursy.add(kurs);
			}
			return foundedKursy;

		}
		
		public List<Kurs> findKursPoIDKursu(int iD_kurs)
		{
			List<Kurs> foundedKursy= new ArrayList<Kurs>();
			for(Kurs kurs : kursy)
			{
				if(kurs.getID_kurs().equals(iD_kurs))
					foundedKursy.add(kurs);
			}
			return foundedKursy;

		}
		
		public Kurs searchKurs(int iD_kurs, String nazwa) {

			for (Kurs kurs : kursy) {
				if (kurs.getID_kurs().equals(iD_kurs) & kurs.getNazwa().equals(nazwa))
					return kurs;
			}
			throw new IllegalStateException("Brak kursu z ID: " + iD_kurs+ " o nazwie: "+nazwa);

		}
		
		public void editWieleKursowPoID_kursuNazwie(Kurs nastepnykurs, int new_iD_kurs, String new_nazwa){
			int possition = 0;
				for(Kurs kurs : kursy){
					if(kurs.getNazwa().equals(nastepnykurs.getNazwa()) & kurs.getID_kurs().equals(nastepnykurs.getID_kurs())){
						
						kursy.set(possition, new Kurs(new_iD_kurs, new_nazwa));
					}
					possition++;
				}

			}
		
////////////////////////////////////////KURSANT///////////////////////////////////////
		
		public List<Kursant> getKursanci() {
			return kursanci;
		}
		
		public void addKursant (int iD_numer, String nazwisko){
			kursanci.add(new Kursant(iD_numer, nazwisko));

		}

		public void setKursanci(List<Kursant> kursanci) {
			this.kursanci = kursanci;
		}

		public void removeWieluKursantow(List<Kursant> kursantDoUsuniecia)
		{
			kursanci.removeAll(kursantDoUsuniecia);
		}
	
		public List<Kursant> findKursantaPoNazwisku(String nazwisko)
		{
			List<Kursant> foundedKursanci= new ArrayList<Kursant>();
			for(Kursant kursant : kursanci)
			{
				if(kursant.getNazwisko().equals(nazwisko))
					foundedKursanci.add(kursant);
			}
			return foundedKursanci;

		}
		
		public List<Kursant> findKursantaPoID(int iD_numer)
		{
			List<Kursant> foundedKursanci= new ArrayList<Kursant>();
			for(Kursant kursant : kursanci)
			{
				if(kursant.getID_numer().equals(iD_numer))
					foundedKursanci.add(kursant);
			}
			return foundedKursanci;

		}
		
		public Kursant searchKursant(int iD_numer, String nazwisko) {

			for (Kursant kursant : kursanci) {
				if (kursant.getID_numer().equals(iD_numer) & kursant.getNazwisko().equals(nazwisko))
					return kursant;
			}
			throw new IllegalStateException("Brak kursanta z ID: " + iD_numer+ " i Nazwiskiem: "+nazwisko);

		}
		
		public void editWieluKursantowPoID_numerNazwisko(Kursant nastepnykursant, int new_iD_numer, String new_nazwisko){
			int possition = 0;
				for(Kursant kursant : kursanci){
					if(kursant.getNazwisko().equals(nastepnykursant.getNazwisko()) & kursant.getID_numer().equals(nastepnykursant.getID_numer())){
						
			kursanci.set(possition, new Kursant(new_iD_numer, new_nazwisko));
					}
					possition++;
				}

			}

////////////////////////////////////////PRINT////////////////////////////////////////		

		public void printKursy(){

			System.out.println("---------------------------------------------------------------------");
			System.out.println("Lista kursow:");
			
				for(Kurs kurs: kursy){
					kurs.printKurs();
				}
		}
		
		public void printKursanci(){

			System.out.println("---------------------------------------------------------------------");
			System.out.println("Lista kursantow:");
				for(Kursant kursant: kursanci){
					kursant.printKursant();
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
			
			System.out.println("---------------------------------------------------------------------");
			}

		}