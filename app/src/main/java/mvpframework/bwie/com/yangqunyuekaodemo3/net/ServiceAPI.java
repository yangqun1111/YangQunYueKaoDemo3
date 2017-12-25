package mvpframework.bwie.com.yangqunyuekaodemo3.net;


import io.reactivex.Flowable;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.DengBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.GouBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.JiaBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.LieBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.XiangBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.ZhuBean;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public interface ServiceAPI {
    @GET(API.LOGIN)
    public Flowable<DengBean> getNews(@Query("mobile") String i, @Query("password") String j);
    @GET(API.REGISTER)
    public Flowable<ZhuBean> getNewss(@Query("mobile") String i, @Query("password") String j);
    @GET(API.PRODUCT_CATAGORY)
    public Flowable<LieBean> getNewsss(@Query("pscid") String i, @Query("page") String j);
    @GET(API.XIANG)
    public Flowable<XiangBean> getNewssss(@Query("pid") String i, @Query("source") String j);
    @GET(API.JIA)
    public Flowable<JiaBean> getNewsssss(@Query("pid") String i, @Query("uid") String j, @Query("source") String k);
    @GET(API.GOU)
    public Flowable<GouBean> getNewssssss(@Query("uid") String i, @Query("source") String j);
}
