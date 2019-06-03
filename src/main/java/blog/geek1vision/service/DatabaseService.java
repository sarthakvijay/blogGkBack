package blog.geek1vision.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import blog.geek1vision.controller.DatabaseQuery;
import blog.geek1vision.controller.DatabaseQuery.QueryBody;
import blog.geek1vision.modal.Josaa;

@Service
public class DatabaseService {

//	@Autowired
//	@Qualifier(value = "DatabaseQuery")
//	Josaa josaa;

	public List<Josaa> databaseQuery(String category, String institute, String gender, Long higherRank,
			Long lowerRank, String alloted_quote) {
		final ResultSet rs;
		List<Josaa> data = new ArrayList();
		int i = 0;
		
		String queryString;
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://gkblog1.c8kndxscvsrj.us-east-1.rds.amazonaws.com:3306/gkroot1", "gkroot1",
					"gkroot1blog");
			Statement stmt = con.createStatement();
			String allQuery = "*";
			if (institute.equals(allQuery)) {
				 queryString = String.format(
						"SELECT * FROM ranking_datavalue1 WHERE (Seat_Pool =\"%s\") AND (Category=\"%s\") AND (Alloted_Quote=\"%s\") AND (Closing >=%d)",
						 gender, category, alloted_quote, lowerRank);
			} else {
				 queryString = String.format(
						"SELECT * FROM ranking_datavalue1 WHERE (Institute_Name = \"%s\") AND (Seat_Pool =\"%s\") AND (Category=\"%s\") AND (Alloted_Quote=\"%s\") AND (Closing >=%d)",
						institute, gender, category, alloted_quote, lowerRank);
			}
			System.out.println(queryString);
			rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				Josaa josaa = new Josaa();
				josaa.setRound(rs.getLong(1));
				josaa.setInstitute_Name(rs.getString(2));
				josaa.setBranch_Name(rs.getString(3));
				josaa.setAlloted_Quote(rs.getString(4));
				josaa.setCategory(rs.getString(5));
				josaa.setSeat_Pool(rs.getString(6));
				josaa.setOpening(rs.getLong(7));
				josaa.setClosing(rs.getLong(8));

				data.add(i, josaa);
				i++;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}
	
	public List<Josaa> databaseIitQuery(String category, String institute, String gender, Long higherRank,
			Long lowerRank, String alloted_quote) {
		final ResultSet rs;
		List<Josaa> data = new ArrayList();
		int i = 0;
		
		String queryString;
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://gkblog1.c8kndxscvsrj.us-east-1.rds.amazonaws.com:3306/gkroot1", "gkroot1",
					"gkroot1blog");
			Statement stmt = con.createStatement();
			String allQuery = "*";
			if (institute.equals(allQuery)) {
				 queryString = String.format(
						"SELECT * FROM iit_ranks WHERE (Seat_Pool =\"%s\") AND (Category=\"%s\") AND (Alloted_Quote=\"%s\") AND (Closing >=%d)",
						 gender, category, alloted_quote, lowerRank);
			} else {
				 queryString = String.format(
						"SELECT * FROM iit_ranks WHERE (Institute_Name = \"%s\") AND (Seat_Pool =\"%s\") AND (Category=\"%s\") AND (Alloted_Quote=\"%s\") AND (Closing >=%d)",
						institute, gender, category, alloted_quote, lowerRank);
			}
			System.out.println(queryString);
			rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				Josaa josaa = new Josaa();
				josaa.setRound(rs.getLong(1));
				josaa.setInstitute_Name(rs.getString(2));
				josaa.setBranch_Name(rs.getString(3));
				josaa.setAlloted_Quote(rs.getString(4));
				josaa.setCategory(rs.getString(5));
				josaa.setSeat_Pool(rs.getString(6));
				josaa.setOpening(rs.getLong(7));
				josaa.setClosing(rs.getLong(8));

				data.add(i, josaa);
				i++;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}

}
