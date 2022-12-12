package resources;

public class ImdbApi {
    String Top250Movies = "https://imdb-api.com/en/API/Top250Movies/k_qk1ppcyh";
    String Top250Tvs = "https://imdb-api.com/en/API/MostPopularTVs/k_qk1ppcyh";
    String InTheaters = "https://imdb-api.com/en/API/InTheaters/k_qk1ppcyh";
    String CommingSoon = "https://imdb-api.com/en/API/ComingSoon/k_qk1ppcyh";

    public String getTop250Movies(){
        return this.Top250Movies;
    }
}
