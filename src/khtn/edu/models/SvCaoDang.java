package khtn.edu.models;

@SuppressWarnings("serial")
public class SvCaoDang extends SinhVien{
	public SvCaoDang() {
		super();
	}
	public SvCaoDang(String msSV, String tenSV, String diaChi, int soTinChi) {
		super(msSV, tenSV, diaChi, soTinChi);
	}
	@Override
	public boolean isTotNghiep() {
		if (this.soTinChi>=150){
			return true;
		}
		return false;
	}
	@Override
	public boolean isCaoDang() {
		return true;
	}
	@Override
	public String toString() {
		return msSV + "  " + tenSV + "	"
				+ diaChi + "	" + soTinChi + "   Cao Đẳng";
	}
}
