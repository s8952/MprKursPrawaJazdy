package services;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import mprKursPrawaJazdy.*;

public class KursDBManager {

	private Connection conn;
	private Statement createTable;
	private PreparedStatement addKursStmt;
	private PreparedStatement getKursStmt;
	private PreparedStatement findKursByNazwaStmt;
	private PreparedStatement deleteKursStmt;
	private PreparedStatement deleteAllKursStmt;
	private PreparedStatement findKursByKurs_nrStmt;



	public KursDBManager(){
	
	try {
		conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");		
		createTable = conn.createStatement();
		ResultSet rs=conn.getMetaData().getTables(null, null, null, null);
		boolean KursTableExists=false;
		while(rs.next())
		{
			if("Kurs".equalsIgnoreCase(rs.getString("Table_Name")))
			{
				KursTableExists=true;
				break;
			}
		}
		if(!KursTableExists)
		{
		createTable.executeUpdate("" +
		"CREATE TABLE Kurs(" +
		"id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY," +
		"kurs_nr Integer, nazwa varchar(100), Osrodki_id integer," + 
		"constraint osrodki_fk foreign key (Osrodki_id) references Osrodki (id)" +
		"" +
		")");
		}

		addKursStmt = conn.prepareStatement("" +"INSERT INTO Kurs (kurs_nr, nazwa, Osrodki_id) VALUES (?, ?, ?)");

		getKursStmt = conn.prepareStatement("" +"SELECT * FROM Kurs");

		findKursByNazwaStmt = conn.prepareStatement("SELECT * FROM Kurs WHERE nazwa= ?");

		deleteKursStmt = conn.prepareStatement("DELETE FROM Kurs WHERE ID = ?");

		deleteAllKursStmt = conn.prepareStatement("DELETE FROM Kurs");
		
		findKursByKurs_nrStmt = conn.prepareStatement("SELECT * FROM Kurs WHERE kurs_nr= ?");

		} catch (SQLException e) {

		e.printStackTrace();
		}
	}

	public void addDBKurs(Kurs k1, List <Integer> Osrodki) {
		try 
		{
				addKursStmt.setInt(1, k1.getID_kurs());
				addKursStmt.setString(2, k1.getNazwa());
				//addKursStmt.setInt(3, k1.get);
				
				for (Integer Id : Osrodki){
					addKursStmt.setInt(3, Id);
					}
				
				addKursStmt.executeUpdate();

		} 
		catch (SQLException e) {
        e.printStackTrace();
		}
	}

	public List<Kurs> getAllKurs(){
		List<Kurs> kursy=new ArrayList<Kurs>();

			try {
				ResultSet rs= getKursStmt.executeQuery();

				while(rs.next())
				{
				kursy.add(new Kurs(rs.getInt("kurs_nr"),rs.getString("nazwa")));
				}

			} catch (SQLException e) {

			e.printStackTrace();
		}

		return kursy;
		}

		public void deleteAllKurs() {
			try {
				deleteAllKursStmt.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

		public List<Integer> findKursByNazwa(String nazwa) {
			try {
				List<Integer> result = new ArrayList<Integer>();
				findKursByNazwaStmt.setString(1, nazwa);
				ResultSet rs = findKursByNazwaStmt.executeQuery();
				while (rs.next())
					result.add(rs.getInt("ID"));
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		public List<Integer> findKursByKurs_nr(int kurs_nr) {
			try {
				List<Integer> result = new ArrayList<Integer>();
				findKursByKurs_nrStmt.setInt(1, kurs_nr);
				ResultSet rs = findKursByKurs_nrStmt.executeQuery();
				while (rs.next())
					result.add(rs.getInt("ID"));
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		public void deleteKurs(List<Integer> kursanci) {
			try {
				for (Integer id : kursanci) {
					deleteKursStmt.setInt(1, id);
					deleteKursStmt.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
