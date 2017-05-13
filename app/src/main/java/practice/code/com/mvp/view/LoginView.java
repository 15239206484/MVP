package practice.code.com.mvp.view;

/**
 * Created by Administrator on 2017/5/13 0013.
 */

public interface LoginView  {

// 开始 的 进度旋转
    void beginProgressDialog();

//    获取 用户名
    String getUserName();

//    获取 密码
String getPassword();

//    跳转到注册页面
    void goToRegister();

//   登录0成功  跳进个人中心
    void goToCenter();

//    结束 的进度
    void dismissProgressDialog();

//    Toast 显示mgs （用户名格式正确，密码格式正确，用户名 和 密码不匹配，网络连接失败，登录成功）
    void showMgs(String mgs);


}
