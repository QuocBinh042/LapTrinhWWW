package bai3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TinTuc")
public class TinTuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maTT;
	@NotBlank(message = "Tiêu đề bắt buộc phải nhập!")
	private String tieuDe;
	@NotBlank(message = "Nội dung tin tức bắt buộc phải nhập!")
	@Size(max = 255, message = "Nội dung tin không quá 255 ký tự!")
	private String noiDungTT;
	@NotBlank(message = "Liên kết bắt buộc phải nhập")
	@Pattern(regexp = "^http://.*", message = "Liên kết phải bắt đầu bởi 'http://'!")
	private String lienKet;
	@ManyToOne
	@JoinColumn(name = "maDM")
	private DanhMuc danhMuc;

	public TinTuc() {
		super();
	}

	public TinTuc(int maTT, String tieuDe, String noiDungTT, String lienKet, DanhMuc danhMuc) {
		super();
		this.maTT = maTT;
		this.tieuDe = tieuDe;
		this.noiDungTT = noiDungTT;
		this.lienKet = lienKet;
		this.danhMuc = danhMuc;
	}

	public TinTuc(String tieuDe, String noiDungTT, String lienKet, DanhMuc danhMuc) {
		super();
		this.tieuDe = tieuDe;
		this.noiDungTT = noiDungTT;
		this.lienKet = lienKet;
		this.danhMuc = danhMuc;
	}

	public int getMaTT() {
		return maTT;
	}

	public void setMaTT(int maTT) {
		this.maTT = maTT;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDungTT() {
		return noiDungTT;
	}

	public void setNoiDungTT(String noiDungTT) {
		this.noiDungTT = noiDungTT;
	}

	public String getLienKet() {
		return lienKet;
	}

	public void setLienKet(String lienKet) {
		this.lienKet = lienKet;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setMaDM(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	@Override
	public String toString() {
		return "TinTuc [maTT=" + maTT + ", tieuDe=" + tieuDe + ", noiDungTT=" + noiDungTT + ", lienKet=" + lienKet
				+ ", danhMuc=" + danhMuc + "]";
	}

}
