package khtn.edu.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import khtn.edu.models.DsSinhVien;
import khtn.edu.models.SvCaoDang;
import khtn.edu.models.SvDaiHoc;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String path = "D:/DsSinhVien.txt";
	public static void main(String[] args) {
		DsSinhVien dsSV = new DsSinhVien();
//		taoThongTinSV(dsSV);
		dsSV=docObjFromFile();
//		themSinhVien(dsSV);
		xoaSinhVien(dsSV);
//		suaThongTinSV(dsSV);
//		ghiObjToFile(dsSV);
//		dsSV.showSVdaiHoc();
//		dsSV.showSVcaoDang();
		dsSV.showSinhVien();
		dsSV.showSVtotNghiep();
		sc.close();
	}
	public static void themSinhVien(DsSinhVien dssv) {
		String tiepTuc; String chonSV; String taoMa;
		do{
			do{	System.out.print("Thêm SV Đại Học(dh), hay Cao Đẳng(cd): ");chonSV = sc.nextLine();
			}while(chonSV.equals("DH")==false&&chonSV.equals("dh")==false&&
					chonSV.equals("CD")==false&&chonSV.equals("cd")==false);
			if (chonSV.equals("DH")||chonSV.equals("dh")){
				SvDaiHoc sv = new SvDaiHoc();
				if (dssv.countSVdaiHoc()<10) taoMa = "DH0"+(dssv.countSVdaiHoc()+1);
				else taoMa = "DH"+(dssv.countSVdaiHoc()+1); sv.setMsSV(taoMa);
				System.out.print("Nhập tên sinh viên: ");String ten = sc.nextLine();
				if (ten.length()<10)sv.setTenSV(ten+"   ");
				if (ten.length()<8)sv.setTenSV(ten+"     ");
				if (ten.length()<6)sv.setTenSV(ten+"       ");
				if (ten.length()<4)sv.setTenSV(ten+"         ");
				else sv.setTenSV(ten);
				System.out.print("Nhập địa chỉ: ");String dc = sc.nextLine();
				if (dc.length()<10) sv.setDiaChi(dc+"   ");
				if (dc.length()<8) sv.setDiaChi(dc+"     ");
				if (dc.length()<6) sv.setDiaChi(dc+"       ");
				if (dc.length()<4) sv.setDiaChi(dc+"         ");
				else sv.setDiaChi(dc);
				String stc;
				do{ System.out.print("Nhập số tín chỉ: ");stc = sc.nextLine();
				}while (isNumber(stc)==false);
				sv.setSoTinChi(Integer.parseInt(stc));
				dssv.addSinhVien(sv);
			}else{ SvCaoDang sv = new SvCaoDang();
				if (dssv.countSVcaoDang()<10) taoMa = "CD0"+(dssv.countSVcaoDang()+1);
				else taoMa = "CD"+(dssv.countSVcaoDang()+1); 
				sv.setMsSV(taoMa);
				System.out.print("Nhập tên sinh viên: ");String ten = sc.nextLine();
				if (ten.length()<10)sv.setTenSV(ten+"   ");
				if (ten.length()<8)sv.setTenSV(ten+"     ");
				if (ten.length()<6)sv.setTenSV(ten+"       ");
				if (ten.length()<4)sv.setTenSV(ten+"         ");
				else sv.setTenSV(ten);
				System.out.print("Nhập địa chỉ: ");String dc = sc.nextLine();
				if (dc.length()<10) sv.setDiaChi(dc+"   ");
				if (dc.length()<8) sv.setDiaChi(dc+"     ");
				if (dc.length()<6) sv.setDiaChi(dc+"       ");
				if (dc.length()<4) sv.setDiaChi(dc+"         ");
				else sv.setDiaChi(dc);
				String stc;
				do{ System.out.print("Nhập số tín chỉ: ");
					stc = sc.nextLine();
				}while (isNumber(stc)==false);
				sv.setSoTinChi(Integer.parseInt(stc));
				dssv.addSinhVien(sv);
			}System.out.println("Thêm tiếp không y/n");tiepTuc = sc.nextLine();
		}while(tiepTuc.equals("Y")||tiepTuc.equals("y"));
	}
	public static void xoaSinhVien(DsSinhVien dssv) {
		String tiepTuc;
		do{	dssv.showSinhVien();
			String svThu;int sv;
			do{
				do{	System.out.print("Bạn muốn xóa sinh viên thứ mấy? ");
				svThu = sc.nextLine();
				}while(isNumber(svThu)==false);
				sv = Integer.parseInt(svThu);
			}while(sv>dssv.countSinhVien());
			dssv.getDsSV().remove(sv-1);
			System.out.print("Xóa tiếp không y/n: ");tiepTuc = sc.nextLine();
		}while(tiepTuc.equals("Y")||tiepTuc.equals("y"));
	}
	public static void suaThongTinSV(DsSinhVien dssv) {
		String tiepTuc;
		String mucCanSua;int soCanSua;
		String svThu;int soSVthu;
		do{	dssv.showSinhVien();
			do{
				do{	System.out.print("Bạn muốn sửa sinh viên thứ mấy? ");
					svThu = sc.next();
				}while(isNumber(svThu)==false);
				soSVthu=Integer.parseInt(svThu);
			}while(soSVthu>dssv.countSinhVien());
			do{
				do{	System.out.print("Sửa tên(1), địa chỉ(2) hay số tín chỉ(3) ");
					mucCanSua = sc.next();
				}while(isNumber(mucCanSua)==false);
				soCanSua=Integer.parseInt(mucCanSua);
			}while(soCanSua!=1&&soCanSua!=2&&soCanSua!=3);
			switch (soCanSua) {
				case 1:
					System.out.println("Tên sẽ bị thay thế: "+dssv.getDsSV().get(soSVthu-1).getTenSV());
					System.out.print("Nhập tên muốn thay thế: ");
					String ten = sc.nextLine();ten = sc.nextLine();
					dssv.getDsSV().get(soSVthu-1).setTenSV(ten);
					break;
				case 2:
					System.out.println("Địa chỉ sẽ bị thay thế: "+dssv.getDsSV().get(soSVthu-1).getDiaChi());
					System.out.print("Nhập địa chỉ muốn thay thế: ");
					String dc = sc.nextLine();dc = sc.nextLine();
					dssv.getDsSV().get(soSVthu-1).setDiaChi(dc);
					break;
				case 3:
					String so;
					do{	System.out.println("Số tín chỉ sẽ bị thay thế: "+dssv.getDsSV().get(soSVthu-1).getSoTinChi());
						System.out.print("Nhập số tín chỉ muốn thay thế: ");
						so = sc.nextLine();so = sc.nextLine();
					}while(isNumber(so)==false);
					dssv.getDsSV().get(soSVthu-1).setSoTinChi(Integer.parseInt(so));
					break;
				default: break;
			} System.out.print("Sửa tiếp không y/n: ");tiepTuc = sc.nextLine();
		}while(tiepTuc.equals("Y")||tiepTuc.equals("y"));
	}
	public static void taoThongTinSV(DsSinhVien dsSV) {
		SvDaiHoc svDH1 = new SvDaiHoc("DH01", "Tran Van A", "Ho Chi Minh", 199);
		SvDaiHoc svDH2 = new SvDaiHoc("DH02", "Nguyen Van B", "Binh Thuan", 201);
		SvCaoDang svCD1 = new SvCaoDang("CD01", "Phan Thi C", "Dong Nai", 160);
		SvCaoDang svCD2 = new SvCaoDang("CD02", "Lam Thi D", "Lam Dong", 120);
		SvCaoDang svCD3 = new SvCaoDang("CD03", "Tran Tuan E", "Ho Chi Minh", 155);
		SvCaoDang svCD4 = new SvCaoDang("CD04", "Doan Thi F", "Da Nang ", 130);
		SvDaiHoc svDH3 = new SvDaiHoc("DH03", "Huynh Van G", "Hai Phong", 215);
		dsSV.addSinhVien(svCD3);
		dsSV.addSinhVien(svCD4);
		dsSV.addSinhVien(svDH3);
		dsSV.addSinhVien(svCD2);
		dsSV.addSinhVien(svCD1);
		dsSV.addSinhVien(svDH2);
		dsSV.addSinhVien(svDH1);
	}
	public static void ghiObjToFile(DsSinhVien dssv) {
		try {ObjectOutputStream objToFile = new ObjectOutputStream
				(new BufferedOutputStream(new FileOutputStream(path)));
		objToFile.writeObject(dssv);
		objToFile.close();
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		}
	}
	public static DsSinhVien docObjFromFile() {
		DsSinhVien dsSV = new DsSinhVien();
		try {ObjectInputStream objFromFile = new ObjectInputStream
				(new BufferedInputStream(new FileInputStream(path)));
		dsSV = (DsSinhVien) objFromFile.readObject();
		objFromFile.close();
		return dsSV;
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		} catch (ClassNotFoundException e) {e.printStackTrace();
		}return dsSV;
	}
	public static boolean isNumber(String number) {
		try{Integer.parseInt(number);return true;
		}catch (NumberFormatException e) {
			System.out.println("Lỗi! Hãy nhập số.");
			return false;
		}
	}
}