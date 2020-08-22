package challenge;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		return getRandom(this.repository.findAll());
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		return getRandom(this.repository.findByActor(actor));
	}

	private Quote getRandom(List<Quote> quotes){
		return quotes.get(new Random().nextInt(quotes.size()));
	}

}
