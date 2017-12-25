package mvpframework.bwie.com.yangqunyuekaodemo3.presenter;


import mvpframework.bwie.com.yangqunyuekaodemo3.bean.LieBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.IlieModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.LieModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;
import mvpframework.bwie.com.yangqunyuekaodemo3.view.IClassActivity;
import retrofit2.Call;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class Liepresenter {
    private IClassActivity iClassActivity;
    private IlieModel ilieModel;

    public Liepresenter(IClassActivity iClassActivity) {
        this.iClassActivity = iClassActivity;
        ilieModel=new LieModel();
    }
    public void zhanshi() {
        ilieModel.lie(new CGSB<LieBean>() {
            @Override
            public void chengGong(LieBean lieBean) {
                iClassActivity.zhan(lieBean);
            }

            @Override
            public void shiBai(Call<LieBean> call) {

            }
        },"1","1");
    }
}
