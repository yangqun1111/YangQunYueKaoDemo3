package mvpframework.bwie.com.yangqunyuekaodemo3.presenter;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mvpframework.bwie.com.yangqunyuekaodemo3.bean.ZhuBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.Izhumodel;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.ZhuModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;
import mvpframework.bwie.com.yangqunyuekaodemo3.view.IregisterActivity;
import retrofit2.Call;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class ZhuPresenter {
    private IregisterActivity iregisterActivity;
    private Izhumodel izhumodel;
    public ZhuPresenter(IregisterActivity iregisterActivity) {
        this.iregisterActivity = iregisterActivity;
        izhumodel=new ZhuModel();
    }

    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
            iregisterActivity.show("请输入密码");
            return false;
        }

        if (pwd.length() != 6) {
            iregisterActivity.show("请输入6位密码");
            return false;
        }
        return true;
    }
    private boolean checkAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            //给用户提示，输入的账号不能为空
            iregisterActivity.show("请输入账号");
            return false;
        }
        if (!isMobileNO(account)) {
            iregisterActivity.show("请输入正确的手机号");
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
        String account = iregisterActivity.getAccount();
        String pwd = iregisterActivity.getPwd();
        //判断账号密码是否正确
        if (checkAccount(account) && checkPwd(pwd)) {
            izhumodel.zhu(new CGSB<ZhuBean>() {
                @Override
                public void chengGong(ZhuBean zhuBean) {
                    //成功以后，回到登陆界面
                    if (zhuBean.getCode().equals("1")) {
                        iregisterActivity.show(zhuBean.getMsg());
                    } else {
                        iregisterActivity.show(zhuBean.getMsg());
                        iregisterActivity.finishAc();
                    }
                }

                @Override
                public void shiBai(Call<ZhuBean> call) {

                }
            },account,pwd);


        }

    }
}
