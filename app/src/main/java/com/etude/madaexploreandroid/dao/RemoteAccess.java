package com.etude.madaexploreandroid.dao;

import android.content.Context;
import android.util.Log;

import com.etude.madaexploreandroid.R;
import com.etude.madaexploreandroid.utili.GsonFactory;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;

public class RemoteAccess extends AsyncHttpClient {
    public static final String BASE_URL = "http://localhost:3000";

    private Map<String, String> params;
    private Map<String, Object> body;
    private Map<String, String> headers;

    public RemoteAccess() {
        super();
        this.params = new HashMap<>();
        this.body = new HashMap<>();
        this.headers = new HashMap<>();
    }
    public RemoteAccess(Map<String, String> params, Map<String, Object> body, Map<String, String> headers) {
        super();
        this.params = params;
        this.body = body;
        this.headers = headers;
    }

    public Map<String, String> getParams() {
        return params;
    }
    public Map<String, Object> getBody() {
        return body;
    }
    public Map<String, String> getHeaders() {
        return headers;
    }

    public void putParam(String name, String value) {
        this.params.put(name, value);
    }
    public void putBody(String name, Object value) {
        this.body.put(name, value);
    }
    public void putHeader(String name, String value) {
        this.headers.put(name, value);
    }

    @Override
    public RequestHandle get(Context context, String path, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;

        if(this.params.isEmpty()) {
            return super.get(context, url, responseHandler);
        } else {
            RequestParams params = new RequestParams(this.params);
            return super.get(context, url, params, responseHandler);
        }
    }

    @Override
    public RequestHandle get(Context context, String path, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.get(context, url, headers, params, responseHandler);
    }

    @Override
    public RequestHandle get(Context context, String path, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.get(context, url, entity, contentType, responseHandler);
    }


    public RequestHandle post(Context context, String path, ContentType contentType, ResponseHandlerInterface responseHandler) throws RuntimeException, UnsupportedEncodingException {
        String url = BASE_URL + path;

        RequestParams params = this.params.isEmpty() ? new RequestParams() :new RequestParams(this.params);
        StringEntity body = this.getBodyEntity();
        Header[] headers = this.getHeadersList();
        String contentTypeStr = contentType.toString();

        if(this.body.isEmpty() && this.headers.isEmpty()) {
            return super.post(context, url, params, responseHandler);
        } else if (this.params.isEmpty() && !this.body.isEmpty() && this.headers.isEmpty()) {
            return super.post(context, url, body, contentTypeStr, responseHandler);
        } else if (this.params.isEmpty() && !this.body.isEmpty() && !this.headers.isEmpty()) {
            return super.post(context, url, headers, body, contentTypeStr, responseHandler);
        } else {
            return super.post(context, url, body, contentTypeStr, responseHandler);
        }
    }

    public RequestHandle post(Context context, String path, ResponseHandlerInterface responseHandler) throws RuntimeException, UnsupportedEncodingException {
        return  this.post(context, path, ContentType.APPLICATION_JSON, responseHandler);
    }

    @Override
    public RequestHandle post(Context context, String path, RequestParams params, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.post(context, url, params, responseHandler);
    }

    @Override
    public RequestHandle post(Context context, String path, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.post(context, url, entity, contentType, responseHandler);
    }

    @Override
    public RequestHandle post(Context context, String path, Header[] headers, RequestParams params, String contentType, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.post(context, url, headers, params, contentType, responseHandler);
    }

    @Override
    public RequestHandle post(Context context, String path, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.post(context, url, headers, entity, contentType, responseHandler);
    }

    @Override
    public RequestHandle put(Context context, String path, RequestParams params, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.put(context, url, params, responseHandler);
    }

    @Override
    public RequestHandle put(Context context, String path, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.put(context, url, entity, contentType, responseHandler);
    }

    @Override
    public RequestHandle put(Context context, String path, Header[] headers, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.put(context, url, headers, entity, contentType, responseHandler);
    }

    @Override
    public RequestHandle delete(Context context, String path, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.delete(context, url, responseHandler);
    }

    @Override
    public RequestHandle delete(Context context, String path, Header[] headers, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.delete(context, url, headers, responseHandler);
    }

    @Override
    public RequestHandle delete(Context context, String path, Header[] headers, RequestParams params, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.delete(context, url, headers, params, responseHandler);
    }

    @Override
    public RequestHandle delete(Context context, String path, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler) {
        String url = BASE_URL + path;
        return super.delete(context, url, entity, contentType, responseHandler);
    }


    protected StringEntity getBodyEntity() throws UnsupportedEncodingException {
        StringEntity entity = null;

        if(this.body.isEmpty()) {
            entity = new StringEntity("{}");
        } else {
            Gson gson = GsonFactory.create();
            String json = gson.toJson(this.body);
            entity = new StringEntity(json);
        }

        return entity;
    }
    protected Header[] getHeadersList() {
        Header[] headers = new Header[this.headers.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            headers[i] = new BasicHeader(entry.getKey(), entry.getValue());
            i++;
        }
        return headers;
    }
}
