package com.masavi.yasearmo.api;

import com.masavi.yasearmo.util.NetworkConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Masavi on 1/6/2017.
 */

public class ServiceGenerator
{
    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(NetworkConstants.BASE_URL);

    public static YaSeArmoAPI createService()
    {
        if (retrofit == null)
        {
            retrofit = builder.build();
        }
        return retrofit.create(YaSeArmoAPI.class);
    }

}
