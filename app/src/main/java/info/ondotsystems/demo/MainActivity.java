package info.ondotsystems.demo;
//https://pixabay.com/api/?key=12973823-c1d0c689a2cb0af7706951221&q=&image_type=photo

import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import info.ondotsystems.demo.DataModel.Hits;
import info.ondotsystems.demo.DataModel.MyImages;
import info.ondotsystems.demo.Utils.Utils;
import info.ondotsystems.demo.adapter.ImagesAdapter;
import info.ondotsystems.demo.interfaces.ImageApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Hits> articleArrayList;
    ImagesAdapter newsAdapter;
    RecyclerView rvHeadline;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvHeadline = findViewById(R.id.rvNews);
        searchView = findViewById(R.id.searchView);
        articleArrayList = new ArrayList<>();
        if (canAuthenticateWithBiometrics()) {
            Toast.makeText(MainActivity.this, getString(R.string.finger_print_available), Toast.LENGTH_SHORT)
                    .show();
            bioMetricPrompt();
        } else {
            Toast.makeText(MainActivity.this, getString(R.string.finger_print_not_available), Toast.LENGTH_SHORT)
                    .show();
        }
        if (Utils.isOnline(this)) {
            searchText(searchView);
            setupRecyclerView();
        } else {
            Toast.makeText(MainActivity.this, getString(R.string.internet_connection_not_available), Toast.LENGTH_SHORT)
                    .show();
        }

    }

    private void searchText(SearchView searchView) {
        searchView.setQueryHint(getString(R.string.search_image));
        searchView.setOnClickListener(v -> searchView.setIconified(false));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                callPixabayImages(query);
                Toast.makeText(getBaseContext(), query, Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                callPixabayImages(newText);
                Toast.makeText(getBaseContext(), newText, Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    private void setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = new ImagesAdapter(MainActivity.this, articleArrayList);

            rvHeadline.setLayoutManager(new GridLayoutManager(this, 2));
            rvHeadline.setAdapter(newsAdapter);
            rvHeadline.setItemAnimator(new DefaultItemAnimator());
            rvHeadline.setNestedScrollingEnabled(true);
        } else {
            newsAdapter.notifyDataSetChanged();
        }
    }

    private void bioMetricPrompt() {
        FragmentActivity activity = this;
        Executor newExecutor = Executors.newSingleThreadExecutor();
        final BiometricPrompt myBiometricPrompt = new BiometricPrompt(activity, newExecutor, new BiometricPrompt.AuthenticationCallback() {
            @Override

//onAuthenticationError is called when a fatal error occurrs//

            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    //
                } else {
                    //
                }
            }

//onAuthenticationSucceeded is called when a fingerprint is matched successfully//

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                searchView.setQueryHint(getString(R.string.search_image));
                searchView.setOnClickListener(v -> searchView.setIconified(false));
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        callPixabayImages(query);
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        callPixabayImages(newText);
                        Toast.makeText(getBaseContext(), newText, Toast.LENGTH_LONG).show();
                        return false;
                    }
                });
            }

//onAuthenticationFailed is called when the fingerprint doesn’t match//

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                //failure
            }
        });

//Create the BiometricPrompt instance//

        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()

//Add some text to the dialog//

                .setTitle(getString(R.string.on_dot_systems))
                .setSubtitle(getString(R.string.finger_print))
                .setDescription(getString(R.string.biometric_auth))
                .setNegativeButtonText(getString(R.string.cancel))

//Build the dialog//

                .build();

//biomteric prompt/
        myBiometricPrompt.authenticate(promptInfo);
    }

    private void callPixabayImages(String query) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ImageApiInterface.PIXABAY_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ImageApiInterface api = retrofit.create(ImageApiInterface.class);

        Call<MyImages> call = api.getMovieDetails(query);
        call.enqueue(new Callback<MyImages>() {
            @Override
            public void onResponse(Call<MyImages> call, Response<MyImages> response) {
                if (response.isSuccessful()) {
                    if ((response.body() != null ? response.body().getHits() : null) != null) {
                        List<Hits> imagesList = response.body().getHits();
                        articleArrayList.clear();
                        articleArrayList.addAll(imagesList);
                        newsAdapter.notifyDataSetChanged();
                    }
                }


            }

            @Override
            public void onFailure(Call<MyImages> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
                Log.e("response", "response" + t);
            }
        });

    }
    private boolean canAuthenticateWithBiometrics() {
        // Check whether the fingerprint can be used for authentication (Android M to P)
        if (Build.VERSION.SDK_INT < 29) {
            FingerprintManagerCompat fingerprintManagerCompat = FingerprintManagerCompat.from(this);
            return fingerprintManagerCompat.hasEnrolledFingerprints() && fingerprintManagerCompat.isHardwareDetected();
        } else {    // Check biometric manager (from Android Q)
            BiometricManager biometricManager = this.getSystemService(BiometricManager.class);
            if (biometricManager != null) {
                return biometricManager.canAuthenticate() == BiometricManager.BIOMETRIC_SUCCESS;
            }
            return false;
        }
    }
}
