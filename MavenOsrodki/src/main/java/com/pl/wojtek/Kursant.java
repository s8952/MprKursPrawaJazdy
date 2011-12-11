package com.pl.wojtek;

	public class Kursant {

		private int ID_numer;
		private String Nazwisko;

		public Kursant(int iD_numer, String nazwisko) {
			this.ID_numer = iD_numer;
			this.Nazwisko = nazwisko;

		}

		public Integer getID_numer() {
			return ID_numer;
		}

		public void setID_numer(int iD_numer) {
			ID_numer = iD_numer;
		}

		public String getNazwisko() {
			return Nazwisko;
		}

		public void setNazwisko(String nazwisko) {
			Nazwisko = nazwisko;
		}

		public void printKursant(){
			
	System.out.println("ID kursanta: "+ID_numer+" ---> Nazwisko kursanta: "+ Nazwisko);
	
		}
		
	}