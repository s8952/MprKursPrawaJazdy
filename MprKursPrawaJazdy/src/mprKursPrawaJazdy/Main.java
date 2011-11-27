package mprKursPrawaJazdy;

import java.util.ArrayList;
import java.util.List;

	public class Main {


		public static void main(String[] args) {

			List<Kursant> kursanci= new ArrayList<Kursant>();

			List<Kurs> kursy= new ArrayList<Kurs>();

			Osrodki Gdansk=new Osrodki("Gdansk", kursanci, kursy);

			Gdansk.addKursant(1 , "Wojciech Gojski");
			Gdansk.addKursant(2 , "Baltazar Ciemny");
			Gdansk.addKursant(3 , "Agnieszka Kowalska");
			Gdansk.addKursant(99 , "Zbigniew Lato");

			Gdansk.addKurs( 1 ,"KursSztaplarka");
			Gdansk.addKurs( 9 ,"KursCiezarowka");
			Gdansk.addKurs( 11 ,"KursOsobowka");
			Gdansk.addKurs(33, "KursHulajnoga");
			
			try		{

			Gdansk.printKursy();
			Gdansk.printKursanci();

			Gdansk.removeMany(Gdansk.findKursantByNazwisko("Baltazar Ciemny"));
			//Gdansk.removeKursant("Baltazar Ciemny");
			Gdansk.removeKursant(99);
			Gdansk.removeKurs(11);
			Gdansk.removeKurs("KursHulajnoga");
			
			Gdansk.printKursy();
			Gdansk.printKursanci();
			
			Gdansk.editKursant_Nazwisko(3 ,"Agnieszka Kowalska", "Bruce Lee");
			Gdansk.editKurs_ID_kurs(1,"KursKoparka", 4);
			
			Gdansk.printKursy();
			Gdansk.printKursanci();
			
			Gdansk.editKurs_Nazwa(4,"KursKoparka", "KursOdzutowiec");
			Gdansk.editKurs_ID_kurs(9,"KursCiezarowka",2);
			
			Gdansk.printKursy();
			Gdansk.printKursanci();
			
			Gdansk.editKursant_Id_numer_Nazwisko(3, "Bruce Lee", 69, "Chuck Norris");
			Gdansk.editKurs_Id_kurs_Nazwa(2,"KursCiezarowka", 5, "KursF1");
			
			}catch (IllegalStateException exception) {
				exception.printStackTrace();	   
		}
			
			Gdansk.printAll();
		}
	}