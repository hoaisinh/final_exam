package repository.dienthoaichinhhang;

import common.CustomFunction;
import common.File;
import model.DienThoaiChinhHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DienThoaiChinhHangRepo implements IDienThoaiChinhHangRepo{
    @Override
    public List<DienThoaiChinhHang> getAll() {
        List<String> lists = File.readFile(PATH_DIENTHOAICHINHHANG);
        List<DienThoaiChinhHang> dienThoaiChinhHangs = new ArrayList<>();
        String[] arrData;
        for (String list:lists){
            arrData = list.split(",");
            dienThoaiChinhHangs.add(new DienThoaiChinhHang(Integer.parseInt(arrData[0]),arrData[1],Integer.parseInt(arrData[2]),Integer.parseInt(arrData[3]),arrData[4],Integer.parseInt(arrData[5]),arrData[6]));
        }
        return dienThoaiChinhHangs;
    }

    @Override
    public void delete(int id) {
        if(findById(id) != null){
            System.out.println("Bạn có muốn xóa điện thoại id=" + id +"\n"
                    +"1: Có \n"
                    +"2: Không"
            );
            int choose = Integer.parseInt(CustomFunction.getDataInput(REG_NUMBER,true));
            if(choose == 1){
                List<DienThoaiChinhHang> lists = getAll();
                for (int i = 0; i < lists.size(); i++) {
                    if(lists.get(i).getId() == id){
                        lists.remove(i);
                        break;
                    }
                }
                File.clearData(PATH_DIENTHOAICHINHHANG);
                for(DienThoaiChinhHang dienThoaiChinhHang:lists){
                    File.writeToFile(PATH_DIENTHOAICHINHHANG,dienThoaiChinhHang.dataToString());
                }
                System.out.println("Bạn đã xóa điện thoại id="+id);
            }else {
                System.out.println("Bạn đã chọn không xóa điện thoại id="+id);
            }

        }else {
            System.out.println("Điện thoại có id "+id+" không tồn tại!");
        }

    }

    @Override
    public DienThoaiChinhHang findById(int id) {
        List<DienThoaiChinhHang> list = getAll();
        for (DienThoaiChinhHang dienThoaiChinhHang:list){
            if(dienThoaiChinhHang.getId() == id){
                return dienThoaiChinhHang;
            }
        }
        return  null;
    }

    @Override
    public void add(DienThoaiChinhHang dienThoaiChinhHang) {
        File.writeToFile(PATH_DIENTHOAICHINHHANG,dienThoaiChinhHang.dataToString());
    }

    @Override
    public List<DienThoaiChinhHang> findByName(String name) {
        List<DienThoaiChinhHang> list = getAll();
        List<DienThoaiChinhHang> listReturn = new ArrayList<>();
        for (DienThoaiChinhHang dienThoaiChinhHang:list){
            if(dienThoaiChinhHang.getTenDienThoai().contains(name)){

                listReturn.add(dienThoaiChinhHang);
            }
        }
        return  listReturn;
    }


}
