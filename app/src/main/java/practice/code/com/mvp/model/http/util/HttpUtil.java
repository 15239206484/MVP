package practice.code.com.mvp.model.http.util;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import practice.code.com.mvp.base.APP;
import practice.code.com.mvp.model.callback.ICallBack;
import practice.code.com.mvp.model.http.biz.IHttp;

/**
 * Created by Administrator on 2017/5/13 0013.
 */

public class HttpUtil implements IHttp {

    private HttpUtil(){}
    private static HttpUtil httpUtil = null;
    public static HttpUtil getInstance(){

        if(httpUtil == null){
            synchronized (HttpUtil.class){
                if(httpUtil == null){
                    httpUtil = new HttpUtil();
                }
            }
        }
return httpUtil;
    }

    @Override
    public void doPOST(String url, Map<String, String> map, final ICallBack iCallBack) {

        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody.Builder formBody = new FormBody.Builder();

        if(map != null) {
            Set<String> keys = map.keySet();
            for (String key : keys) {
                String value = map.get(key);
                formBody.add(key, value);
            }
        }

        Request request  =  new Request.Builder()
                .url(url)
                .post(formBody.build())
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {


                APP.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.fail(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String string = response.body().string();

                APP.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.success(string);
                    }
                });
            }
        });
    }



    @Override
    public void doGET(String url, Map<String, String> map, final ICallBack iCallBack) {
        OkHttpClient okHttpClient = new OkHttpClient();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");
        if(map != null){
            Set<String> keys = map.keySet();
            for (String key : keys) {
                String value = map.get(key);
               stringBuffer.append(key).append("=").append(value).append("&");
            }
            url = url + stringBuffer.substring(0, stringBuffer.length() - 1);
        }

        Request request  =  new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {


                APP.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.fail(e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String string = response.body().string();

                APP.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.success(string);
                    }
                });
            }
        });
    }
}
