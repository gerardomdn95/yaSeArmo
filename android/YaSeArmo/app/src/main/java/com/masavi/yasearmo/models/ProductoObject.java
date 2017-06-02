package com.masavi.yasearmo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masavi on 1/6/2017.
 */

public class ProductoObject
{
    @SerializedName("array")
    List<Producto> productos = new ArrayList<>();
}
