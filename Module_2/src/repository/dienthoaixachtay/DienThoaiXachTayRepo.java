package repository.dienthoaixachtay;

import common.CustomFunction;
import common.File;
import model.DienThoaiChinhHang;
import model.DienThoaiXachTay;
import repository.dienthoaichinhhang.IDienThoaiChinhHangRepo;

import java.util.ArrayList;
import java.util.List;

public class DienThoaiXachTayRepo implements IDienThoaiXachTayRepo {


    @Override
    public List<DienThoaiXachTay> getAll() {
        List<String> lists = File.readFile(PATH_XACHTAY);
        List<DienThoaiXachTay> dienThoaiXachTays = new ArrayList<>();
        String[] arrData;
        for (String list:lists){
            arrData = list.split(",");
            dienThoaiXachTays.add(new DienThoaiXachTay(Integer.parseInt(arrData[0]),arrData[1],Integer.parseInt(arrData[2]),Integer.parseInt(arrData[3]),arrData[4],arrData[5],arrData[6]));
        }
        return dienThoaiXachTays;
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
                List<DienThoaiXachTay> lists = getAll();
                for (int i = 0; i < lists.size(); i++) {
                    if(lists.get(i).getId() == id){
                        lists.remove(i);
                        break;
                    }
                }
                File.clearData(PATH_XACHTAY);
                for(DienThoaiXachTay dienThoaiXachTay:lists){
                    File.writeToFile(PATH_XACHTAY,dienThoaiXachTay.dataToString());
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
    public DienThoaiXachTay findById(int id) {
        List<DienThoaiXachTay> list = getAll();
        for (DienThoaiXachTay dienThoaiXachTay:list){
            if(dienThoaiXachTay.getId() == id){
                return dienThoaiXachTay;
            }
        }
        return  null;
    }

    @Override
    public void add(DienThoaiXachTay dienThoaiXachTay) {
        File.writeToFile(PATH_XACHTAY,dienThoaiXachTay.dataToString());
    }

    @Override
    public List<DienThoaiXachTay> findByName(String name) {
        List<DienThoaiXachTay> list = getAll();
        List<DienThoaiXachTay> listReturn = new ArrayList<>();
        for (DienThoaiXachTay dienThoaiXachTay:list){
            if(dienThoaiXachTay.getTenDienThoai().contains(name)){

                listReturn.add(dienThoaiXachTay);
            }
        }
        return  listReturn;
    }
}
