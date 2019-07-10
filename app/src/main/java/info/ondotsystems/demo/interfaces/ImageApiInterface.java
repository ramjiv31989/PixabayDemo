package info.ondotsystems.demo.interfaces;


import info.ondotsystems.demo.DataModel.MyImages;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImageApiInterface {
    String PIXABAY_URL = "https://pixabay.com/";

    @GET("api/?key=12973823-c1d0c689a2cb0af7706951221&image_type=photo")
    Call<MyImages> getMovieDetails(@Query("q") String query);
}
