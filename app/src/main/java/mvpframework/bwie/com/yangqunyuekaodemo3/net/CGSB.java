package mvpframework.bwie.com.yangqunyuekaodemo3.net;

import retrofit2.Call;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public interface CGSB<T> {
    void chengGong(T t);
    void shiBai(Call<T> call);
}
