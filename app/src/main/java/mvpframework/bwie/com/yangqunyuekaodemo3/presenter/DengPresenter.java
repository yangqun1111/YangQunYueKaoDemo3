package mvpframework.bwie.com.yangqunyuekaodemo3.presenter;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mvpframework.bwie.com.yangqunyuekaodemo3.bean.DengBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.DengModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.Idengmodel;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;
import mvpframework.bwie.com.yangqunyuekaodemo3.view.IMainActivity;
import retrofit2.Call;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class DengPresenter {
    private IMainActivity iMainActivity;
    private Idengmodel idengmodel;

    public DengPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        idengmodel=new DengModel();
    }
    public void login(){
        String account = iMainActivity.getAccount();
        String pwd = iMainActivity.getPwd();
        if (checkAccount(account) && checkPwd(pwd)) {
            //去调用model，进行登陆
            idengmodel.deng(new CGSB<DengBean>() {
                @Override
                public void chengGong(final DengBean dengBean) {
                    iMainActivity.show(dengBean.getMsg());
                    //跳转
                    iMainActivity.toClassAc();
                }

                @Override
                public void shiBai(Call<DengBean> call) {

                }
            },account,pwd);
        }

    }
    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
            iMainActivity.show("请输入密码");
            return false;
        }

        if (pwd.length() != 6) {
            iMainActivity.show("请输入6位密码");
            return false;
        }
        return true;
    }
    private boolean checkAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            //给用户提示，输入的账号不能为空
            iMainActivity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(account)) {
            iMainActivity.show("请输入正确的手机号");
            return false;
        }
        return true;
    }
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    public void register() {
        //其实就是跳转到注册页面
        iMainActivity.toRegisterAc();
    }
}
