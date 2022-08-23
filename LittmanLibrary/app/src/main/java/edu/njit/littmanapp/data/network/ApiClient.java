package edu.njit.littmanapp.data.network;

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor;

import edu.njit.littmanapp.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static Retrofit customRetrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUrl.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getClient(String url) {
        if (customRetrofit == null) {
            customRetrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient())
                    .build();
        }
        return customRetrofit;
    }


    private static OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)); // http traffic in Log
            builder.addInterceptor(new OkHttpProfilerInterceptor());   // http traffic ok-http profiler stdio plugin
        }
        return builder.build();
    }

    public static NetworkInterface apiInterface;

    public static NetworkInterface getApi() {
        if (apiInterface == null) {
            apiInterface = ApiClient.getClient(ApiUrl.BASE_URL).create(NetworkInterface.class);
        }

        return apiInterface;
    }
}
