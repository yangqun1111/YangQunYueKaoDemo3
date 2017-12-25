package mvpframework.bwie.com.yangqunyuekaodemo3.presenter;


import mvpframework.bwie.com.yangqunyuekaodemo3.bean.JiaBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.IjiaModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.JiaModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;
import mvpframework.bwie.com.yangqunyuekaodemo3.view.IxiangActivity;
import retrofit2.Call;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class JiaPresenter {
    private IxiangActivity ixiangActivity;
    private IjiaModel ijiaModel;

    public JiaPresenter(IxiangActivity ixiangActivity) {
        this.ixiangActivity = ixiangActivity;
        ijiaModel = new JiaModel();
    }

    public void jiaru() {
        String id = ixiangActivity.getid();
        ijiaModel.jia(new CGSB<JiaBean>() {
            @Override
            public void chengGong(final JiaBean jiaBean) {
                ixiangActivity.jia(jiaBean);
            }

            @Override
            public void shiBai(Call<JiaBean> call) {

            }
        }, id, "1933", "android");
    }
}
