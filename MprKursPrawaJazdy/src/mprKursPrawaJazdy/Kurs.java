package mprKursPrawaJazdy;


	public class Kurs {

		private int ID_kurs;
		private String Nazwa;

		public Kurs(int iD_kurs, String nazwa) {

			this.ID_kurs = iD_kurs;
			this.Nazwa = nazwa;
		}

		public Integer getID_kurs() {
			return ID_kurs;
		}

		public void setID_kurs(int iD_kurs) {
			ID_kurs = iD_kurs;
		}

		public String getNazwa() {
			return Nazwa;
		}

		public void setNazwa(String nazwa) {
			Nazwa = nazwa;
		}

		public void printKurs()
		{
			System.out.println("ID Kursu: " + ID_kurs +" ---> Nazwa Kursu: " + Nazwa);
		}

	}

