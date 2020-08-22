package challenge;

import org.springframework.beans.factory.annotation.Autowired;

public class QuoteController {

	@Autowired
	private QuoteService service;

	public Quote getQuote() {
		return service.getQuote();
	}

	public Quote getQuoteByActor(String actor) {
		return service.getQuoteByActor(actor);
	}

}
