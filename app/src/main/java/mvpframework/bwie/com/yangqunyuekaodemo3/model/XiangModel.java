package mvpframework.bwie.com.yangqunyuekaodemo3.model;


import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.XiangBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.RetrofitHelper;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class XiangModel implements IxiangModel {
    @Override
    public void xiang(final CGSB<XiangBean> cgsb, String i, String j) {
        Flowable<XiangBean> obserable = RetrofitHelper.getServiceAPI().getNewssss(i,j);//被观察者

        obserable.subscribeOn(Schedulers.io())//被观察者       Scheduler （调度器）

                .observeOn(AndroidSchedulers.mainThread())       //观察者 切换到主线程
                .subscribe(new Consumer<XiangBean>() {
                    @Override
                    public void accept(XiangBean xiangBean) throws Exception {
                        //调用成功的方法
                        cgsb.chengGong(xiangBean);
                    }
                });
    }
}
