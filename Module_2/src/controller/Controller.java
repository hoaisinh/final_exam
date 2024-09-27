package controller;

import common.CustomFunction;
import common.File;
import model.DienThoaiChinhHang;
import model.DienThoaiXachTay;
import service.dienthoaichinhhang.DienThoaiChinhHangService;
import service.dienthoaixachtay.DienThoaiXachTayService;

import java.util.List;

public class Controller {
    String tenDienThoai;
    int giaBan;
    int soLuong;
    String nhaSanXuat;
    private final static String PATH_CHINHAHNG = "src/data/dienthoaichinhhang.csv";
    String PATH_XACHTAY = "src/data/dienthoaixachtay.csv";
    public final static String REG_NUMBER = "^[0-9]+$";
    public final static String REG_SODUONG = "^(0|[1-9]\\d*)(\\.\\d+)?$";
    public final static String REG_SOKHONGQUA730 = "^(?:[1-6]?\\d{1,2}|7[0-2][0]|73[0])$";
    private final DienThoaiChinhHangService dienThoaiChinhHangService = new DienThoaiChinhHangService();
    private final DienThoaiXachTayService dienThoaiXachTayService = new DienThoaiXachTayService();
    public void getAllDTChinhHang(){
        List<DienThoaiChinhHang> lists;
        lists = dienThoaiChinhHangService.getAll();
        for(DienThoaiChinhHang dienThoaiChinhHang:lists){
            System.out.println(dienThoaiChinhHang.toString());
        }
    }
    public void timDienThoaiChinhHang(int type){
        if(type == 1){
            System.out.println("Nhập id điện thoại cần tìm kiếm");
            int id = Integer.parseInt(CustomFunction.getDataInput(REG_NUMBER,true));
            DienThoaiChinhHang dienThoaiChinhHang  = dienThoaiChinhHangService.findById(id);
            if(dienThoaiChinhHang != null){
                System.out.println("Đã tìm thấy điện thoại:");
                System.out.println(dienThoaiChinhHang.toString());
            }else {
                System.out.println("Không tìm thấy");
            }
        }else {
            System.out.println("Nhập tên điện thoại cần tìm kiếm");
            String ten = CustomFunction.getDataInput("",true);
            List<DienThoaiChinhHang> dienThoaiChinhHangs  = dienThoaiChinhHangService.findByName(ten);
            if(!dienThoaiChinhHangs.isEmpty()){
                System.out.println("Đã tìm thấy điện thoại:");
                for (DienThoaiChinhHang dienThoaiChinhHang:dienThoaiChinhHangs){
                    System.out.println(dienThoaiChinhHang.toString());
                }
            }else {
                System.out.println("Không tìm thấy");
            }
        }

    }
    public void xoaDienThoaiChinhHang(){
        System.out.println("Nhập id điện thoại cần xóa");
        int id = Integer.parseInt(CustomFunction.getDataInput(REG_NUMBER,true));
        dienThoaiChinhHangService.delete(id);
        getAllDTChinhHang();
    }
    public void inputData(){
        System.out.println("Nhập tên điện thoại");
        tenDienThoai = CustomFunction.getDataInput("",true);
        System.out.println("Nhập giá bán điện thoại");
        giaBan = Integer.parseInt(CustomFunction.getDataInput(REG_SODUONG,true));
        System.out.println("Nhập số lượng điện thoại");
        soLuong = Integer.parseInt(CustomFunction.getDataInput(REG_SODUONG,true));
        System.out.println("Nhập nhà sản xuất");
        nhaSanXuat = CustomFunction.getDataInput("",true);
    }
    public void themDienThoaiChinhHang(){
        inputData();
        System.out.println("Nhập thời gian bảo hành");
        int thoiGianBaoHanh = Integer.parseInt(CustomFunction.getDataInput(REG_SOKHONGQUA730,true));
        System.out.println("Chọn phạm vi bảo hành\n" +
                "1-Toàn Quốc \n" +
                "2-Quốc tế");

        int temp = Integer.parseInt(CustomFunction.getDataInput(REG_NUMBER,true));
        String phamViBaoHanh;
        if(temp == 1){
            phamViBaoHanh = "Toàn Quốc";
        }else if(temp == 2) {
            phamViBaoHanh = "Quốc tế";
        }else {
            phamViBaoHanh = "không xác định";
        }
        int id = File.getMaxID(PATH_CHINHAHNG)+1;
        DienThoaiChinhHang dienThoaiChinhHang = new DienThoaiChinhHang(id,tenDienThoai,giaBan,soLuong,nhaSanXuat,thoiGianBaoHanh,phamViBaoHanh);
        dienThoaiChinhHangService.add(dienThoaiChinhHang);
    }
    public void getAllDTXachTay(){
        List<DienThoaiXachTay> lists;
        lists = dienThoaiXachTayService.getAll();
        for(DienThoaiXachTay dienThoaiXachTay:lists){
            System.out.println(dienThoaiXachTay.toString());
        }
    }
    public void timDienThoaiXachTay(int type){
        if(type == 1){
            System.out.println("Nhập id điện thoại cần tìm kiếm");
            int id = Integer.parseInt(CustomFunction.getDataInput(REG_NUMBER,true));
            DienThoaiXachTay dienThoaiXachTay  = dienThoaiXachTayService.findById(id);
            if(dienThoaiXachTay != null){
                System.out.println("Đã tìm thấy điện thoại:");
                System.out.println(dienThoaiXachTay.toString());
            }else {
                System.out.println("Không tìm thấy");
            }
        }else {
            System.out.println("Nhập tên điện thoại cần tìm kiếm");
            String ten = CustomFunction.getDataInput("",true);
            List<DienThoaiXachTay> dienThoaiXachTays  = dienThoaiXachTayService.findByName(ten);
            if(!dienThoaiXachTays.isEmpty()){
                System.out.println("Đã tìm thấy điện thoại:");
                for (DienThoaiXachTay dienThoaiXachTay:dienThoaiXachTays){
                    System.out.println(dienThoaiXachTays.toString());
                }
            }else {
                System.out.println("Không tìm thấy");
            }
        }

    }
    public void xoaDienThoaiXachTay(){
        System.out.println("Nhập id điện thoại cần xóa");
        int id = Integer.parseInt(CustomFunction.getDataInput(REG_NUMBER,true));
        dienThoaiXachTayService.delete(id);
        getAllDTXachTay();
    }

    public void themDienThoaiXachTay(){
        inputData();
        System.out.println("Nhập quốc gia xách tay");
        String quocGia = CustomFunction.getDataInput("",true);
        System.out.println("Chọn trạng thái \n" +
                "1-Da sua chua \n" +
                "2-Chua sua chua");

        int temp = Integer.parseInt(CustomFunction.getDataInput(REG_NUMBER,true));
        String trangThai;
        if(temp == 1){
            trangThai = "Da sua chua";
        }else if(temp == 2) {
            trangThai = "Chua sua chua";
        }else {
            trangThai = "không xác định";
        }
        int id = File.getMaxID(PATH_XACHTAY)+1;
        DienThoaiXachTay dienThoaiXachTay = new DienThoaiXachTay(id,tenDienThoai,giaBan,soLuong,nhaSanXuat,quocGia,trangThai);
        dienThoaiXachTayService.add(dienThoaiXachTay);
    }
}
