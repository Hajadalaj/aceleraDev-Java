package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/quote")
public class QuoteController {

	@Autowired
	private QuoteService service;

	@GetMapping
	public Quote getQuote() {
		return this.service.getQuote();
	}

	@GetMapping("/{actor}")
	public Quote getQuoteByActor(@PathVariable("actor") String actor) {
		return this.service.getQuoteByActor(actor);
	}

}
