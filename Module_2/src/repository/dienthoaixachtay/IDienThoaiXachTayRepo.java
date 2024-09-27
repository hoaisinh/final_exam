package repository.dienthoaixachtay;

import model.DienThoaiXachTay;
import repository.IDienThoaiRepo;

public interface IDienThoaiXachTayRepo extends IDienThoaiRepo<DienThoaiXachTay> {
    String PATH_XACHTAY = "src/data/dienthoaixachtay.csv";
    String REG_NUMBER = "^[0-9]+$";
}
