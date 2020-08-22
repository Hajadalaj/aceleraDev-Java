package challenge;

public interface QuoteRepository {

 Quote getQuote();
	
	Quote getQuoteByActor(String actor);

}
