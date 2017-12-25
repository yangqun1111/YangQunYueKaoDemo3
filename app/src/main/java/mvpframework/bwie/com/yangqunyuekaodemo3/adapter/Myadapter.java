package mvpframework.bwie.com.yangqunyuekaodemo3.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import mvpframework.bwie.com.yangqunyuekaodemo3.R;
import mvpframework.bwie.com.yangqunyuekaodemo3.bean.LieBean;
import mvpframework.bwie.com.yangqunyuekaodemo3.view.XiangActivity;

;

/**
 * Created by DangByMySide on 2017/12/21.
 */

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<LieBean.DataBean> list;

    public Myadapter(Context context, List<LieBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.iiv.setImageURI("https://m.360buyimg.com/n0/jfs/t1930/284/2865629620/390243/e3ade9c4/56f0a08fNbd3a1235.jpg!q70.jpg");
        myViewHolder.price.setText("¥"+list.get(position).getPrice()+"");
        myViewHolder.name.setText(list.get(position).getTitle());
        myViewHolder.iiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangActivity.class);
                intent.putExtra("pid",list.get(position).getPid()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView iiv;
        private final TextView price;
        private final TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            iiv = itemView.findViewById(R.id.iiv);
            price = itemView.findViewById(R.id.price);
            name = itemView.findViewById(R.id.name);
        }
    }

}
