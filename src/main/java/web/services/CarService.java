package web.services;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> cars = new ArrayList<>();
    public CarService() {
        for (int i = 1; i <= 5; i++) {
            cars.add(new Car("carModel#" + i, 2005 + i, "photo"));
        }
    }
    public List<Car> getCars() {
        return cars;
    }
}
