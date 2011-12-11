package com.pl.wojtek.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pl.wojtek.Kursant;
import com.pl.wojtek.Kurs;
import com.pl.wojtek.Osrodki;

public class OsrodkiTest {
	
	private List<Kursant> kursanci= new ArrayList<Kursant>();
	private List<Kurs> kursy= new ArrayList<Kurs>();
	private Osrodki Test = new Osrodki("Test", kursanci, kursy);
	
	@Before	
	public void setUp() throws Exception {
		
		kursanci.add(new Kursant(1 , "nazwisko1"));
		kursanci.add(new Kursant(2 , "nazwisko2"));
		kursanci.add(new Kursant(3 , "nazwisko3"));
		kursy.add(new Kurs (1, "nazwa1"));
		kursy.add(new Kurs (2, "nazwa2"));
		
	}
	
	@After	
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testOsrodkiStringListOfKursantListOfKurs() {
		assertSame(Test.getKursanci(), kursanci);
		assertEquals(Test.getKursy(), kursy);
	}

	@Test
	public void testOsrodkiString() {
		assertTrue(Test.getNazwa().equals("Test"));

	}

	@Test
	public void testGetNazwa() {
		assertTrue(Test.getNazwa().equals("Test"));
	}

	@Test
	public void testSetNazwa() {
		Test.setNazwa("Test1");
		
		assertTrue(Test.getNazwa().equals("Test1"));
		assertSame("Test1", Test.getNazwa());
	}

	@Test
	public void testGetKursy() {
		assertTrue(Test.getKursy().equals(kursy));
		assertFalse(Test.getKursy().equals(kursanci));
	}

	@Test
	public void testAddKurs() {
		assertTrue(kursy.size() == 2);
		assertFalse(kursy.size() == 4);
	}

	@Test
	public void testAddWieleKursow() {
		assertTrue(kursy.size() == 2);
		assertFalse(kursy.size() == 3);
	}

	@Test
	public void testSetKursy() {
		
		assertSame(kursy, Test.getKursy());
		assertEquals(Test.getKursy() , kursy);
	}

	@Test
	public void testRemoveWieleKursow() {
		Test.removeWieleKursow(Test.findKursPoNazwie("nazwisko3"));
		
		assertTrue(kursy.size() == 2);

	}

	@Test
	public void testFindKursPoNazwie() {
		assertNotNull(Test.findKursPoNazwie("nazwa1"));

	}

	@Test
	public void testFindKursPoIDKursu() {
		assertNotNull(Test.findKursPoIDKursu(1));
	}

	@Test
	public void testSearchKurs() {
		assertNotNull(Test.searchKurs(1, "nazwa1"));
		
	}

	@Test
	public void testEditWieleKursowPoID_kursuNazwie() {
		Test.editWieleKursowPoID_kursuNazwie(Test.searchKurs(1, "nazwa1"), 2, "new_nazwa");
		
		assertFalse(kursy.get(0).getNazwa()=="nazwa1");
		assertTrue(kursy.get(0).getID_kurs()==2);
		assertSame("new_nazwa", Test.searchKurs(2, "new_nazwa").getNazwa());
		assertNotSame("nazwa1", Test.searchKurs(2, "new_nazwa").getNazwa());
	}

	@Test
	public void testGetKursanci() {
		assertTrue(Test.getKursanci().equals(kursanci));
		assertFalse(Test.getKursanci().equals(kursy));	}

	@Test
	public void testAddKursant() {
		assertTrue(kursanci.size() == 3);
		assertFalse(kursanci.size() == 4);	}

	@Test
	public void testSetKursanci() {
		assertSame(kursanci, Test.getKursanci());
		assertEquals(Test.getKursanci(), kursanci);
	}

	@Test
	public void testRemoveWieluKursantow() {
		Test.removeWieluKursantow(Test.findKursantaPoNazwisku("nazwa2"));
		
		assertFalse(kursanci.size() == 2);
		
	}

	@Test
	public void testFindKursantaPoNazwisku() {
		assertNotNull(Test.findKursantaPoNazwisku("nazwisko1"));	

	}

	@Test
	public void testFindKursantaPoID() {
		assertNotNull(Test.findKursantaPoID(2));
	}

	@Test
	public void testSearchKursant() {
		assertNotNull(Test.searchKursant(1, "nazwisko1"));	
	}

	@Test
	public void testEditWieluKursantowPoID_numerNazwisko() {
		Test.editWieluKursantowPoID_numerNazwisko(Test.searchKursant(1, "nazwisko1"), 2, "new_nazwisko");
		
		assertFalse(kursanci.get(0).getNazwisko()=="nazwisko1");
		assertTrue(kursanci.get(0).getID_numer()==2);
		assertSame("new_nazwisko", Test.searchKursant(2, "new_nazwisko").getNazwisko());
		assertNotSame("nazwisko1", Test.searchKursant(2, "new_nazwisko").getNazwisko());
	}

}
