package repository.dienthoaichinhhang;

import model.DienThoaiChinhHang;
import repository.IDienThoaiRepo;

public interface IDienThoaiChinhHangRepo extends IDienThoaiRepo<DienThoaiChinhHang> {
    String PATH_DIENTHOAICHINHHANG = "src/data/dienthoaichinhhang.csv";
    String REG_NUMBER = "^[0-9]+$";
}
