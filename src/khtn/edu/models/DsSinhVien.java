package khtn.edu.models;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DsSinhVien implements Serializable{
	private ArrayList<SinhVien> dsSV;
	public DsSinhVien() {
		dsSV = new ArrayList<SinhVien>();
	}
	public DsSinhVien(ArrayList<SinhVien> dsSV) {
		super();
		this.dsSV = dsSV;
	}
	public ArrayList<SinhVien> getDsSV() {
		return dsSV;
	}
	public void setDsSV(ArrayList<SinhVien> dsSV) {
		this.dsSV = dsSV;
	}
	public void addSinhVien(SinhVien sv) {
		this.dsSV.add(sv);
	}
	public int countSVtotNghiep(){
		int count = 0;
		for (SinhVien sv : this.dsSV) {
			if (sv.isTotNghiep()){
				count+=1;
			}
		}return count;
	}
	public void showSVtotNghiep(){
		if (countSVtotNghiep()>0){
			int count = 0;
			System.out.println("<< Có "+countSVtotNghiep()+" SV tốt nghiệp:("+countSVdaiHocIsTotNghiep()+" SV Đại Học, "+countSVcaoDangIsTotNghiep()+" SV Cao Đẳng) >>");
			System.out.println("stt MãSố   Họ và Tên   	   ĐịaChỉ      TínChỉ    Hệ");
			System.out.println("--- ----  ------------  -------------  ------ --------");
			for (SinhVien sv : this.dsSV) {
				if (sv.isTotNghiep()){
					System.out.print(" ");
					System.out.print(count+=1);
					System.out.print(": ");
					System.out.println(sv);
				}
			}System.out.println("======================================================");
		}
	}
	public int countSVdaiHocIsTotNghiep(){
		int count = 0;
		for (SinhVien sv : this.dsSV) {
			if (sv.isDaiHoc()&&sv.isTotNghiep()){
				count+=1;
			}
		}return count;
	}
	public int countSVdaiHoc(){
		int count = 0;
		for (SinhVien sv : this.dsSV) {
			if (sv.isDaiHoc()){
				count+=1;
			}
		}return count;
	}
	public void showSVdaiHoc(){
		if (countSVdaiHoc()>0){
			int count = 0;
			System.out.println("<< Có "+countSVdaiHoc()+" sinh viên Đại Học:("+countSVdaiHocIsTotNghiep()+" SV Đạt, "+(countSVdaiHoc()-countSVdaiHocIsTotNghiep())+" SV không đạt >>");
			System.out.println("stt MãSố   Họ và Tên   	   ĐịaChỉ      TínChỉ  KếtQuả");
			System.out.println("--- ----  ------------  -------------  ------  -------");
			for (SinhVien sv : this.dsSV) {
				if (sv.isDaiHoc()){
					System.out.print(" ");
					System.out.print(count+=1);
					System.out.print(": ");
					if(sv.getSoTinChi()<200)
						System.out.println(sv.toString().replaceAll("  Đại Học", "	Không"));
					else System.out.println(sv.toString().replaceAll("  Đại Học", "	Đạt"));
				}
			}System.out.println("======================================================");
		}
	}
	public int countSVcaoDangIsTotNghiep(){
		int count = 0;
		for (SinhVien sv : this.dsSV) {
			if (sv.isCaoDang()&&sv.isTotNghiep()){
				count+=1;
			}
		}return count;
	}
	public int countSVcaoDang(){
		int count = 0;
		for (SinhVien sv : this.dsSV) {
			if (sv.isCaoDang()){
				count+=1;
			}
		}return count;
	}
	public void showSVcaoDang(){
		if (countSVcaoDang()>0){
			int count = 0;
			System.out.println("<< Có "+countSVcaoDang()+" sinh viên Cao Đẳng:("+countSVcaoDangIsTotNghiep()+" SV Đạt, "+(countSVcaoDang()-countSVcaoDangIsTotNghiep())+" SV không đạt >>");
			System.out.println("stt MãSố   Họ và Tên   	   ĐịaChỉ      TínChỉ  KếtQuả");
			System.out.println("--- ----  ------------  -------------  ------  -------");
			for (SinhVien sv : this.dsSV) {
				if (sv.isCaoDang()){
					System.out.print(" ");
					System.out.print(count+=1);
					System.out.print(": ");
					if(sv.getSoTinChi()<150)
						System.out.println(sv.toString().replaceAll("  Cao Đẳng", "	Không"));
					else System.out.println(sv.toString().replaceAll("  Cao Đẳng", "	Đạt"));
				}
			}System.out.println("======================================================");
		}
	}
	public int countSinhVien(){
		int count = 0;
		for (@SuppressWarnings("unused") SinhVien sv : this.dsSV) {
			count+=1;
		}return count;
	}
	public void showSinhVien(){
		int count = 0;
		System.out.println("<<< Có "+countSinhVien()+" sinh viên: ("+countSVcaoDang()+" SV Cao Đẳng, "+countSVdaiHoc()+" SV Đại Học) >>>");
		System.out.println("stt MãSố   Họ và Tên   	   ĐịaChỉ      TínChỉ    Hệ");
		System.out.println("--- ----  ------------  -------------  ------ --------");
		for (SinhVien sv : this.dsSV) {
				System.out.print(" ");
				System.out.print(count+=1);
				System.out.print(": ");
				System.out.println(sv);
		}System.out.println("======================================================");
	}
	@Override
	public String toString() {
		return "DsSinhVien [dsSV=" + dsSV + "]";
	}
}
