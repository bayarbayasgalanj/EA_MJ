package cs544;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StreamController {

	@GetMapping("/live")
	public String getAll(Model model) {

		// model.addAttribute("cars", carService.getAll());
		return "stream";
	}
}