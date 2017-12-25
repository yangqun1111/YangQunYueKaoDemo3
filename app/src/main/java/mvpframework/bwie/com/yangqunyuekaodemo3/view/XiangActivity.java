package mvpframework.bwie.com.yangqunyuekaodemo3.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvpframework.bwie.com.yangqunyuekaodemo3.R;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.JiaBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.XiangBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.presenter.JiaPresenter;
import mvpframework.bwie.com.yangqunyuekaodemo3.presenter.XiangPresenter;

public class XiangActivity extends AppCompatActivity implements IxiangActivity {

    @BindView(R.id.lei_xiangback)
    ImageView leiXiangback;
    @BindView(R.id.lei_xiangll)
    LinearLayout leiXiangll;
    @BindView(R.id.ttttt)
    TextView ttttt;
    @BindView(R.id.iv)
    SimpleDraweeView iv;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv01)
    TextView tv01;
    @BindView(R.id.lei_xiangrlv)
    LinearLayout leiXiangrlv;
    @BindView(R.id.ttttt2)
    TextView ttttt2;
    @BindView(R.id.btn01)
    Button btn01;
    @BindView(R.id.btn02)
    Button btn02;
    private String pid;
    private XiangPresenter xiangPresenter;
    private JiaPresenter jiaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        xiangPresenter = new XiangPresenter(this);
        jiaPresenter = new JiaPresenter(this);
        xiangPresenter.xiangxi();
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jiaPresenter.jiaru();
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(XiangActivity.this, GouActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void zhan(XiangBean xiangBean) {
        XiangBean.DataBean data = xiangBean.getData();
        String images = data.getImages();
        String[] split = images.split("|");
        iv.setImageURI(split[0]);
        tv.setText(data.getTitle());
        tv01.setText(data.getPrice()+"");
    }

    @Override
    public String getid() {
        return pid;
    }

    @Override
    public void jia(JiaBean jiaBean) {
        Toast.makeText(XiangActivity.this, jiaBean.getMsg(), Toast.LENGTH_LONG).show();
    }

}
