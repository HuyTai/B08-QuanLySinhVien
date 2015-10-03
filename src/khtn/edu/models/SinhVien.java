package khtn.edu.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SinhVien implements Serializable{
	String msSV;
	String tenSV;
	String diaChi;
	int soTinChi;
	public SinhVien() {
		super();
	}
	public SinhVien(String msSV, String tenSV, String diaChi, int soTinChi) {
		super();
		this.msSV = msSV;
		this.tenSV = tenSV;
		this.diaChi = diaChi;
		this.soTinChi = soTinChi;
	}
	public String getMsSV() {
		return msSV;
	}
	public void setMsSV(String msSV) {
		this.msSV = msSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getSoTinChi() {
		return soTinChi;
	}
	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}
	public boolean isTotNghiep() {
		return false;
	}
	public boolean isCaoDang() {
		return false;
	}
	public boolean isDaiHoc() {
		return false;
	}
	@Override
	public String toString() {
		return "SV [" + msSV + "	" + tenSV + "	"
				+ diaChi + "	" + soTinChi + "]";
	}
}
