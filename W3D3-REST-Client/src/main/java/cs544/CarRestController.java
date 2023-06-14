package cs544;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class CarRestController {
    @Autowired
	private CarService carService;

	@GetMapping("/carall/")
	public List<Car> getAll() {
		return carService.getAll();
	}

	@GetMapping("/car/{id}")
	public Car get(@PathVariable long id) {
		return carService.get(id);
	}

	@PostMapping("/carnew/")
	public RedirectView post(@RequestBody Car car) {
        // System.out.println("===========");
		long id = carService.add(car);
		return new RedirectView("/car/" + id);
	}

	@PutMapping("/car/{id}")
	public void put(@PathVariable long id, @RequestBody Car car) {
        System.out.println("==========="+car.getId()+"  "+id);
		if (id != car.getId()) {
			throw new IllegalArgumentException();
		}
		carService.update(car);
	}

	@DeleteMapping("/car/{id}")
	public void delete(@PathVariable long id) {
		carService.delete((int)id);
	}
}
