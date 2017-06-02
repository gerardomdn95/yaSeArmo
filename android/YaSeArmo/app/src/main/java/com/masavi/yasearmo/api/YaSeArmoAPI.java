package com.masavi.yasearmo.api;

import com.masavi.yasearmo.models.Producto;
import com.masavi.yasearmo.util.NetworkConstants;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Masavi on 1/6/2017.
 */

public interface YaSeArmoAPI
{
    @GET(NetworkConstants.PATH_SEARCH_PRODUCTOS)
    public Call<List<Producto>> buscarEventos();

}
