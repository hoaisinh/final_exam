package model;

import java.time.LocalDate;

public class DienThoaiChinhHang extends DienThoai{
    int thoiGianBaoHanh;
    String phamViBaoHanh;

    public DienThoaiChinhHang(int id, String tenDienThoai, int giaBan, int soLuong, String nhaSanXuat, int thoiGianBaoHanh, String phamViBaoHanh) {
        super(id, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public String getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(String phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return "Điện thoại chính hãng: {"+super.toString()+"DienThoaiChinhHang{" +
                "thoiGianBaoHanh=" + thoiGianBaoHanh +
                ", phamViBaoHanh='" + phamViBaoHanh + '\'' +
                "} ";
    }

    @Override
    public String dataToString() {
        return super.dataToString()+","+thoiGianBaoHanh+","+phamViBaoHanh;
    }
}
