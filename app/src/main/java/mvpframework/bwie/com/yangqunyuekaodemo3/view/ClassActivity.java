package mvpframework.bwie.com.yangqunyuekaodemo3.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvpframework.bwie.com.yangqunyuekaodemo3.R;
import mvpframework.bwie.com.yangqunyuekaodemo3.adapter.Myadapter;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.LieBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.presenter.Liepresenter;

public class ClassActivity extends AppCompatActivity implements IClassActivity {

    @BindView(R.id.rv)
    RecyclerView rv;
    private Liepresenter liepresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        ButterKnife.bind(this);
        liepresenter = new Liepresenter(this);
        liepresenter.zhanshi();
    }

    @Override
    public void zhan(LieBean lieBean) {
        Myadapter myadapter = new Myadapter(this, lieBean.getData());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(myadapter);
    }
}
