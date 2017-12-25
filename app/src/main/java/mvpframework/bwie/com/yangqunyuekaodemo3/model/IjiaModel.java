package mvpframework.bwie.com.yangqunyuekaodemo3.model;


import mvpframework.bwie.com.yangqunyuekaodemo3.bean.JiaBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public interface IjiaModel {
    void jia(CGSB<JiaBean> cgsb, String i, String j, String k);
}
