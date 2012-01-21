package mprKursPrawaJazdy;
/*zmiana*/
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
		}
	}