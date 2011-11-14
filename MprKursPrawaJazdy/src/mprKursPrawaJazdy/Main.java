package mprKursPrawaJazdy;

import java.util.ArrayList;
import java.util.List;

	public class Main {


		public static void main(String[] args) {

			List<Kursant> kursanci= new ArrayList<Kursant>();

			List<Kurs> kursy= new ArrayList<Kurs>();

			Osrodki Osrodki1=new Osrodki("Osrodki1", kursanci, kursy);

			Osrodki1.addKursant(1 , "Wojciech Gojski");
			Osrodki1.addKursant(2 , "Baltazar Ciemny");
			Osrodki1.addKursant(3 , "Agnieszka Kowalska");

			Osrodki1.addKurs( 1 ,"KursSztaplarka");
			Osrodki1.addKurs( 9 ,"KursCiezarowka");
			Osrodki1.addKurs( 11 ,"KursOsobowka");

			Osrodki1.printKursy();
			Osrodki1.printKursanci();

			Osrodki1.removeKursant("Baltazar Ciemny");
			Osrodki1.removeKurs("KursOsobowka");
			
			Osrodki1.printKursy();
			Osrodki1.printKursanci();
			
			Osrodki1.editKursant_Nazwisko(3 ,"Agnieszka Kowalska", "Bruce Lee");
			Osrodki1.editKurs_ID_kurs(1,"KursKoparka", 4);
			
			Osrodki1.printKursy();
			Osrodki1.printKursanci();
			
			Osrodki1.editKurs_Nazwa(4,"KursKoparka", "KursOdzutowiec");
			Osrodki1.editKurs_ID_kurs(9,"KursCiezarowka",2);
			
			Osrodki1.printKursy();
			Osrodki1.printKursanci();

			Osrodki1.printAll();
		}
	}