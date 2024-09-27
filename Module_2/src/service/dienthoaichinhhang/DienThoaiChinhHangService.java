package service.dienthoaichinhhang;

import model.DienThoaiChinhHang;
import repository.dienthoaichinhhang.DienThoaiChinhHangRepo;

import java.util.List;

public class DienThoaiChinhHangService implements IDienThoaiChinhHangService{
    private final DienThoaiChinhHangRepo dienThoaiChinhHangRepo = new DienThoaiChinhHangRepo();
    @Override
    public List<DienThoaiChinhHang> getAll() {
        return dienThoaiChinhHangRepo.getAll();
    }

    @Override
    public void delete(int id) {
        dienThoaiChinhHangRepo.delete(id);
    }

    @Override
    public DienThoaiChinhHang findById(int id) {
        return dienThoaiChinhHangRepo.findById(id);
    }

    @Override
    public List<DienThoaiChinhHang> findByName(String name) {
        return dienThoaiChinhHangRepo.findByName(name);
    }

    @Override
    public void add(DienThoaiChinhHang dienThoaiChinhHang) {
        dienThoaiChinhHangRepo.add(dienThoaiChinhHang);
    }
}
