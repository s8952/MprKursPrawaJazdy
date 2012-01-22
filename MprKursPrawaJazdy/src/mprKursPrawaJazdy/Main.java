package mprKursPrawaJazdy;

import java.util.ArrayList;
import java.util.List;

import services.KursDBManager;
import services.OsrodkiDBManager;

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

			Gdansk.printAll();

			try	{

			Gdansk.removeWieluKursantow(Gdansk.findKursantaPoNazwisku("Baltazar Ciemny"));
			Gdansk.removeWieluKursantow(Gdansk.findKursantaPoID(99));

			Gdansk.removeWieleKursow(Gdansk.findKursPoIDKursu(11));
			Gdansk.removeWieleKursow(Gdansk.findKursPoNazwie("KursHulajnoga"));

			Gdansk.printKursanci();	
			Gdansk.printKursy();

			Gdansk.editWieluKursantowPoID_numerNazwisko(Gdansk.searchKursant(3,"Agnieszka Kowalska"),3, "Bruce Lee");
			Gdansk.editWieleKursowPoID_kursuNazwie(Gdansk.searchKurs(1,"KursSztaplarka"),4, "KursOdzutowiec");

			Gdansk.printKursanci();	
			Gdansk.printKursy();

			Gdansk.editWieleKursowPoID_kursuNazwie(Gdansk.searchKurs(9,"KursCiezarowka"),2, "KursCiezarowka");

			Gdansk.printKursanci();	
			Gdansk.printKursy();

			Gdansk.editWieleKursowPoID_kursuNazwie(Gdansk.searchKurs(2,"KursCiezarowka"),5, "KursF1");

			}catch (IllegalStateException exception) {
				exception.printStackTrace();	   
		}

			Gdansk.printAll();
			
			/*---------------------DB-------------------------*/
			
				System.out.println(" 000000000000000000  JDBC  ooooooooooooooooooo ");
				
	OsrodkiDBManager OsrodkiDB = new OsrodkiDBManager();
	OsrodkiDB.deleteAllOsrodki();
	KursDBManager KursDB= new KursDBManager();
	KursDB.deleteAllKurs();
	
	
	Kurs kurs1 = new Kurs(21, "KursLopata");
	KursDB.addDBKurs(kurs1);
	Kurs kurs2 = new Kurs(22 , "KursWidly");
	KursDB.addDBKurs(kurs2);
	Kurs kurs3 = new Kurs(23 , "KursPomocy");
	KursDB.addDBKurs(kurs3);

	
	Osrodki Osrodki2 = new Osrodki("Sopot", kursanci, kursy);
	OsrodkiDB.addOsrodki(Osrodki2);
	Osrodki Osrodki3 = new Osrodki("Gdynia", kursanci, kursy);
	OsrodkiDB.addOsrodki(Osrodki3);

		}
	}

