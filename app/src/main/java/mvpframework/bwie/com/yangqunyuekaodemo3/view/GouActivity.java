package mvpframework.bwie.com.yangqunyuekaodemo3.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvpframework.bwie.com.yangqunyuekaodemo3.R;
import mvpframework.bwie.com.yangqunyuekaodemo3.adapter.ShopAdapter;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.GouBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.eventbus.MessageEvent;
import mvpframework.bwie.com.yangqunyuekaodemo3.eventbus.PriceAndCountEvent;
import mvpframework.bwie.com.yangqunyuekaodemo3.presenter.GouPresenter;

public class GouActivity extends AppCompatActivity implements IgouActivity{
    @BindView(R.id.gobian)
    TextView gobian;
    @BindView(R.id.elv)
    ExpandableListView elv;
    @BindView(R.id.checkbox2)
    CheckBox checkbox2;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_num)
    TextView tvNum;
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    private ShopAdapter adapter;
    private ArrayList<List<GouBean.DataBean.ListBean>> lists;
    private List<GouBean.DataBean> list;
    private boolean flagedit=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initView();
        new GouPresenter(this).getNewss();
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        gobian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = gobian.getText().toString().trim();
                if (trim.equals("编辑")) {
                    gobian.setText("完成");
                } else {
                    gobian.setText("编辑");
                }
                for (int i = 0; i < lists.size(); i++) {
                    List<GouBean.DataBean.ListBean> listBeans = lists.get(i);
                    for (int j = 0; j < listBeans.size(); j++) {
                        listBeans.get(j).setXy(flagedit);
                    }
                }
                flagedit = !flagedit;
                adapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) findViewById(R.id.checkbox2);
        mTvPrice = (TextView) findViewById(R.id.tv_price);
        mTvNum = (TextView) findViewById(R.id.tv_num);
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }

    @Override
    public void gouwu(GouBean gouBean) {
        list = gouBean.getData();
        lists = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<GouBean.DataBean.ListBean> datas = list.get(i).getList();
            lists.add(datas);
        }
        adapter = new ShopAdapter(GouActivity.this, list, lists);
        mElv.setAdapter(adapter);
        mElv.setGroupIndicator(null);
        //默认其他全部展开
        for (int i = 0; i < list.size(); i++) {
            mElv.expandGroup(i);
        }
    }
}
