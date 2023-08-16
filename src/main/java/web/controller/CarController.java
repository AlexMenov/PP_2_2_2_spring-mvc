package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.services.CarService;
import java.util.List;

@Controller
public class CarController {
    private final ApplicationContext applicationContext;
    private List<Car> cars;

    @Autowired
    public CarController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        CarService carService = getApplicationContext().getBean(CarService.class);
        setCars(carService.getCars());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @GetMapping(value = "cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        if (count > getCars().size()) {
            count = getCars().size();
        }
        model.addAttribute("cars", getCars().subList(0, count));
        return "cars";
    }
}

