package test;

import java.util.ArrayList;
import java.util.Scanner;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {

	public static void main(String[] args) {
		/* Test Insert */
		
//		Sach sach1 = new Sach("LTJV", "Lập trình Java", 50000, 2025);
//		Sach sach2 = new Sach("LTC", "Lập trình C", 70000, 2030);
//		
//		SachDAO.getInstance().insert(sach2);
//		
		
//		for (int i = 0; i < 10; i++) {
//			Sach sach = new Sach("LT"+i, "Lập trình i: "+i, 20000, 2015);
//			SachDAO.getInstance().insert(sach);
//		}
		
		
		
		/* Test update */
//		Sach sach2 = new Sach("LTC", "Lập trình C changed" , 100000, 2030);
//		SachDAO.getInstance().update(sach2);
//		
		
		/* Test delete */
//		for (int i = 0; i < 1000; i++) {
//			Sach sach = new Sach("LT"+i, "Lập trình i: "+i, 20000, 2015);
//			SachDAO.getInstance().delete(sach);
//		}
		/* Test Select All */
//		
//		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
//		for (Sach sach : list) {
//			System.out.println(sach.toString());
//		}
		
		/* Test Select By ID */
/*		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma ID: ");
		String find_ID = sc.nextLine();
		
		Sach s = new Sach();
		s.setId(find_ID);
		Sach sach2 = SachDAO.getInstance().selectById(s);
		System.out.println(sach2);*/
		
		
/*		System.out.println("---------------------");
		Sach find = new Sach();
		find.setId("LTC");
		Sach sach2 = SachDAO.getInstance().selectById(find);
		System.out.println(sach2);*/
	
		/* Test selectByCondition */
//		System.out.println("---------------------");
//		ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition("giaBan<700000");
//		for (Sach sach : list2) {
//			System.out.println(sach.toString());
//		}
		 
	}
}
