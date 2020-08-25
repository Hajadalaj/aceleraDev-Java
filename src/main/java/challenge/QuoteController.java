package challenge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/quote")
public class QuoteController {

	private final QuoteService service;

	public QuoteController(QuoteService service) {
		this.service = service;
	}
	
	@GetMapping
	public Quote getQuote() {
		return this.service.getQuote();
	}

	@GetMapping("/{actor}")
	public Quote getQuoteByActor(@PathVariable("actor") String actor) {
		return this.service.getQuoteByActor(actor);
	}

}
