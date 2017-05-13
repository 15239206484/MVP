package practice.code.com.mvp.model.http.biz;

import practice.code.com.mvp.model.callback.ICallBack;

/**
 * Created by Administrator on 2017/5/13 0013.
 */

public interface IHomeHttp {

    void getLoginMessage(String userName, String passWord, ICallBack iCallBack);

}
