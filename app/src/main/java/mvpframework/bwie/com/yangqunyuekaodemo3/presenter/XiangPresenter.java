package mvpframework.bwie.com.yangqunyuekaodemo3.presenter;


import mvpframework.bwie.com.yangqunyuekaodemo3.bean.XiangBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.IxiangModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.XiangModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;
import mvpframework.bwie.com.yangqunyuekaodemo3.view.IxiangActivity;
import retrofit2.Call;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class XiangPresenter {
    private IxiangActivity ixiangActivity;
    private IxiangModel ixiangModel;

    public XiangPresenter(IxiangActivity ixiangActivity) {
        this.ixiangActivity = ixiangActivity;
        ixiangModel=new XiangModel();
    }
    public void xiangxi() {
        String id = ixiangActivity.getid();
        ixiangModel.xiang(new CGSB<XiangBean>() {
            @Override
            public void chengGong(XiangBean xiangBean) {
                ixiangActivity.zhan(xiangBean);
            }

            @Override
            public void shiBai(Call<XiangBean> call) {

            }
        },id,"android");
    }

}
