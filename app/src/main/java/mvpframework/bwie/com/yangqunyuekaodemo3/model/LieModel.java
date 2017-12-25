package mvpframework.bwie.com.yangqunyuekaodemo3.model;


import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.LieBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.RetrofitHelper;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class LieModel implements IlieModel {
    @Override
    public void lie(final CGSB<LieBean> cgsb, String i, String j) {
        Flowable<LieBean> obserable = RetrofitHelper.getServiceAPI().getNewsss(i,j);//被观察者

        obserable.subscribeOn(Schedulers.io())//被观察者       Scheduler （调度器）

                .observeOn(AndroidSchedulers.mainThread())       //观察者 切换到主线程
                .subscribe(new Consumer<LieBean>() {
                    @Override
                    public void accept(LieBean lieBean) throws Exception {
                        //调用成功的方法
                        cgsb.chengGong(lieBean);
                    }
                });
    }
}
