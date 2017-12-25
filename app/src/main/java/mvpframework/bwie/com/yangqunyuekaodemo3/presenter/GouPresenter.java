package mvpframework.bwie.com.yangqunyuekaodemo3.presenter;


import mvpframework.bwie.com.yangqunyuekaodemo3.bean.GouBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.GouModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.model.IgouModel;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;
import mvpframework.bwie.com.yangqunyuekaodemo3.view.IgouActivity;
import retrofit2.Call;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class GouPresenter {
    private IgouActivity igouActivity;
    private IgouModel igouModel;

    public GouPresenter(IgouActivity igouActivity) {
        this.igouActivity = igouActivity;
        igouModel=new GouModel();
    }
    public void getNewss(){
        igouModel.gou(new CGSB<GouBean>() {
            @Override
            public void chengGong(final GouBean gouBean) {
                igouActivity.gouwu(gouBean);
            }

            @Override
            public void shiBai(Call<GouBean> call) {

            }
        },"1933","android");
    }
    public void destroy() {
        igouActivity = null;

    }
}
