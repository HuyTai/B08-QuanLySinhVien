package khtn.edu.models;

@SuppressWarnings("serial")
public class SvDaiHoc extends SinhVien{
	public SvDaiHoc() {
		super();
	}
	public SvDaiHoc(String msSV, String tenSV, String diaChi, int soTinChi) {
		super(msSV, tenSV, diaChi, soTinChi);
	}
	@Override
	public boolean isTotNghiep() {
		if (this.soTinChi>=200){
			return true;
		}
		return false;
	}
	@Override
	public boolean isDaiHoc() {
		return true;
	}
	@Override
	public String toString() {
		return msSV + "  " + tenSV + "	"
				+ diaChi + "	" + soTinChi + "   Đại Học";
	}
}
