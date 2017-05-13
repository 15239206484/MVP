package practice.code.com.mvp.model.http.biz;

import java.util.Map;

import practice.code.com.mvp.model.callback.ICallBack;

/**
 * Created by Administrator on 2017/5/13 0013.
 */

public interface IHttp {

    void doPOST(String url, Map<String,String> map, ICallBack iCallBack);

    void doGET(String url, Map<String,String> map, ICallBack iCallBack);

}
