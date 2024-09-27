package service.dienthoaixachtay;

import model.DienThoaiXachTay;
import repository.dienthoaixachtay.DienThoaiXachTayRepo;

import java.util.List;

public class DienThoaiXachTayService implements IDienThaoiXachTayService{
    private final DienThoaiXachTayRepo dienThoaiXachTayRepo = new DienThoaiXachTayRepo();
    @Override
    public List<DienThoaiXachTay> getAll() {
        return dienThoaiXachTayRepo.getAll();
    }

    @Override
    public void delete(int id) {
        dienThoaiXachTayRepo.delete(id);
    }

    @Override
    public DienThoaiXachTay findById(int id) {
        return dienThoaiXachTayRepo.findById(id);
    }

    @Override
    public List<DienThoaiXachTay> findByName(String name) {
        return dienThoaiXachTayRepo.findByName(name);
    }

    @Override
    public void add(DienThoaiXachTay dienThoaiXachTay) {
        dienThoaiXachTayRepo.add(dienThoaiXachTay);
    }
}
