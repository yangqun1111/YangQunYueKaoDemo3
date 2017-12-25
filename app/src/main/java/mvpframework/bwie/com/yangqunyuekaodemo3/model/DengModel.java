package mvpframework.bwie.com.yangqunyuekaodemo3.model;


import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.DengBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.RetrofitHelper;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class DengModel implements Idengmodel{
    @Override
    public void deng(final CGSB<DengBean> cgsb, String i, String j) {
        Flowable<DengBean> obserable = RetrofitHelper.getServiceAPI().getNews(i,j);//被观察者

        obserable.subscribeOn(Schedulers.io())//被观察者       Scheduler （调度器）

                .observeOn(AndroidSchedulers.mainThread())       //观察者 切换到主线程
                .subscribe(new Consumer<DengBean>() {
                    @Override
                    public void accept(DengBean dengBean) throws Exception {
                        //调用成功的方法
                        cgsb.chengGong(dengBean);
                    }
                });
    }
}
