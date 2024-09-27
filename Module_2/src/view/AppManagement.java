package view;

import common.CustomFunction;
import controller.Controller;

public class AppManagement {
    public final static String REG_SELECT_NUMBER = "^[1-9]$";
    private static final Controller CONTROLLER = new Controller();
    public static void main(String[] args) {
        mainMenu();
    }
    public static void mainMenu(){
        do{
            System.out.println(
                    """
                            ---CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI---\s
                            1. Thêm Mơi \s
                            2. Xóa\s
                            3. Xem danh sách điện thoại \s
                            4. Tìm kiếm\s
                            5. Thoát"""
            );
            System.out.println("Enter your select");
            int select = Integer.parseInt(CustomFunction.getDataInput(REG_SELECT_NUMBER,true));
            switch (select){
                case 1:
                    themDienThoai();break;
                case 2:
                    xoaDienThoai();break;
                case 3:
                    xemDienThoai();break;
                case 4:
                    timDienThoai();break;
                case 5:
                    System.exit(1);break;
                default:
                    System.exit(1);break;
            }
        }while (true);
    }
    public static void xemDienThoai(){
        System.out.println(
                """
                        -------------Chọn loại điện thoại-------------\s
                        1. Chính hãng\s
                        2. Xách tay"""
        );
        int select = Integer.parseInt(CustomFunction.getDataInput(REG_SELECT_NUMBER,true));
        switch (select){
            case 1:
                CONTROLLER.getAllDTChinhHang();break;
            case 2:
               CONTROLLER.getAllDTXachTay();break;


        }
    }
    public static void themDienThoai(){
        System.out.println(
                """
                        -------------Chọn loại điện thoại-------------\s
                        1. Chính hãng\s
                        2. Xách tay"""
        );
        int select = Integer.parseInt(CustomFunction.getDataInput(REG_SELECT_NUMBER,true));
        switch (select){
            case 1:
                CONTROLLER.themDienThoaiChinhHang();break;
            case 2:
                CONTROLLER.themDienThoaiXachTay();break;


        }
    }
    public static void xoaDienThoai(){
        System.out.println(
                """
                        -------------Chọn loại điện thoại-------------\s
                        1. Chính hãng\s
                        2. Xách tay"""
        );
        int select = Integer.parseInt(CustomFunction.getDataInput(REG_SELECT_NUMBER,true));
        switch (select){
            case 1:
                CONTROLLER.xoaDienThoaiChinhHang();break;
            case 2:
                CONTROLLER.xoaDienThoaiXachTay();break;


        }
    }
    public static void timDienThoai(){
        System.out.println(
                """
                        -------------Chọn loại điện thoại-------------\s
                        1. tìm ĐT chính hãng bằng id\s
                        2. tìm ĐT chính hãng bằng tên\s
                        3. Tìm đt xách tay bằng id \s
                        4. Tìm đt xách tay bằng tên"""
        );
        int select = Integer.parseInt(CustomFunction.getDataInput(REG_SELECT_NUMBER,true));

        switch (select){
            case 1:
                CONTROLLER.timDienThoaiChinhHang(1);break;
            case 2:
                CONTROLLER.timDienThoaiChinhHang(2);break;
            case 3:
                CONTROLLER.timDienThoaiXachTay(1);break;
            case 4:
                CONTROLLER.timDienThoaiXachTay(2);break;

        }
    }
}
