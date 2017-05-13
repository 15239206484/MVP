package practice.code.com.mvp.model.http.util;

import java.util.HashMap;
import java.util.Map;

import practice.code.com.mvp.contact.Urls;
import practice.code.com.mvp.model.callback.ICallBack;
import practice.code.com.mvp.model.http.biz.IHomeHttp;

/**
 * Created by Administrator on 2017/5/13 0013.
 */

public class LoginUtil implements IHomeHttp {
    @Override
    public void getLoginMessage(String userName, String passWord, ICallBack iCallBack) {


        Map<String,String> map = new HashMap<>();
        map.put("username",userName);
        map.put("pwd",passWord);
        HttpUtil.getInstance().doPOST(Urls.LOGINURL, map,iCallBack);

    }
}
