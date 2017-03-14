package com.example.sony.MyMarket.AsyncTasks;

/**
 * Created by Sony on 14-03-2017.
 */
import org.json.JSONArray;


public interface AsyncResponse {
    void onSuccess(String message, JSONArray jsonData);
    void onFailure(String message);
}
