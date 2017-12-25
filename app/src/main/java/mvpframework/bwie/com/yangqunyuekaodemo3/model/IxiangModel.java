package mvpframework.bwie.com.yangqunyuekaodemo3.model;


import mvpframework.bwie.com.yangqunyuekaodemo3.bean.XiangBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.net.CGSB;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public interface IxiangModel {
    void xiang(CGSB<XiangBean> cgsb, String i, String j);
}
