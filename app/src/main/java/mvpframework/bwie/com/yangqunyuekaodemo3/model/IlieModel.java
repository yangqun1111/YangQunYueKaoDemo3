package mvpframework.bwie.com.yangqunyuekaodemo3.model;


import mvpframework.bwie.com.yangqunyuekaodemo3.bean.LieBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public interface IlieModel {
    void lie(CGSB<LieBean> cgsb, String i, String j);
}
