package practice.code.com.mvp.presenter;

import android.util.Log;

import practice.code.com.mvp.model.callback.ICallBack;
import practice.code.com.mvp.model.http.biz.IHttp;
import practice.code.com.mvp.model.http.biz.IHomeHttp;
import practice.code.com.mvp.model.http.util.LoginUtil;
import practice.code.com.mvp.view.LoginView;

/**
 * Created by Administrator on 2017/5/13 0013.
 */

public class LoginPre  implements ILogin {

    LoginView loginView;
    IHomeHttp iHomeHttp;
    public LoginPre( LoginView loginView){
        this.loginView  =  loginView;
        iHomeHttp=new LoginUtil();

    }

    @Override
    public void getMessage() {
        iHomeHttp.getLoginMessage(loginView.getUserName(), loginView.getPassword(), new ICallBack() {
            @Override
            public void success(String mgs) {
           loginView.showMgs("登录成功");
                loginView.goToCenter();
                Log.e("tag",mgs);
            }

            @Override
            public void fail(String mgs) {
                loginView.showMgs("登录失败");
                Log.e("tag",mgs);
            }
        });
    }
}
