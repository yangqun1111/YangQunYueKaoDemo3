package mvpframework.bwie.com.yangqunyuekaodemo3.model;


import mvpframework.bwie.com.yangqunyuekaodemo3.bean.ZhuBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public interface Izhumodel {
    void zhu(CGSB<ZhuBean> cgsb, String i, String j);
}
