package mvpframework.bwie.com.yangqunyuekaodemo3.model;


import mvpframework.bwie.com.yangqunyuekaodemo3.bean.DengBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public interface Idengmodel {
    void deng(CGSB<DengBean> cgsb, String i, String j);
}
