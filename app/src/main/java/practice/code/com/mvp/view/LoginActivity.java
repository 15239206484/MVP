package practice.code.com.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import practice.code.com.mvp.MainActivity;
import practice.code.com.mvp.R;
import practice.code.com.mvp.base.BaseAcitivty;
import practice.code.com.mvp.presenter.LoginPre;

public class LoginActivity extends BaseAcitivty implements LoginView {


    @Bind(R.id.login_username)
    EditText loginUsername;
    @Bind(R.id.login_password)
    EditText loginPassword;
    @Bind(R.id.login_resigter)
    TextView loginResigter;
    @Bind(R.id.login_success)
    Button loginSuccess;
    @Bind(R.id.activity_login)
    LinearLayout activityLogin;
    private LoginPre loginPre;


    @Override
    public int initLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void initData() {
        loginPre = new LoginPre(this);

    }

    @Override
    public void beginProgressDialog() {

    }

    @Override
    public String getUserName() {

        return loginUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return loginPassword.getText().toString().trim();
    }

    @Override
    public void goToRegister() {

    }

    @Override
    public void goToCenter() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void showMgs(String mgs) {
        Toast.makeText(this, ""+mgs, Toast.LENGTH_SHORT).show();
    }



    @OnClick({R.id.login_resigter, R.id.login_success})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_resigter:
                break;
            case R.id.login_success:
                loginPre.getMessage();
                break;
        }
    }
}
