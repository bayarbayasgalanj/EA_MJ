package cs544;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarService {
    
    @Autowired
    private ICarDao carDao;
    
    public List<Car> getAll() {
        return carDao.getAll();
    }

    public int add(Car car) {
        carDao.add(car);
        return car.getId();
    }

    public Car get(long id) {
        return carDao.get((int)id);
    }

    public void update(Car car) {
        carDao.update(car);
    }

    public void delete(int id) {
        carDao.delete(id);
    }
}