package com.example.zz.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.zz.myapplication.adpater.DataAdapter;
import com.example.zz.myapplication.bean.ChildBean;
import com.example.zz.myapplication.bean.GroupBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：测试类
 * 创建人：zz
 * 创建时间：2017/8/10 13:33
 */
public class MainActivity extends Activity {

    private ExpandableListView expendListView;
    private DataAdapter adapter;
    List<GroupBean> groups = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    /**
     * 初始化数据源
     */
    private void initData() {
        for (int i = 0; i < 10; i++) {
            GroupBean groupBean = new GroupBean();
            groupBean.setName("父类"+i);
            List<ChildBean> childs = new ArrayList<>();
            ChildBean childBean = new ChildBean("子类1",0,"0");
            ChildBean childBean1 = new ChildBean("子类2",1,"0");
            ChildBean childBean2 = new ChildBean("子类3",2,"0");
            childs.add(childBean);
            childs.add(childBean1);
            childs.add(childBean2);
            groupBean.setChilds(childs);
            groups.add(groupBean);
        }
        adapter = new DataAdapter(getApplicationContext(),groups);
        expendListView.setAdapter(adapter);


        //-----------------------默认所有group展开---------------------------------------------
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            expendListView.expandGroup(i);
        }
    }

    /**
     * 初始化UI
     */
    private void initView() {
        expendListView = ((ExpandableListView) findViewById(R.id.expendable_listview));

        //----------------------------------------点击Group不合并-------------------------------------------------------
        expendListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });


        expendListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if(0 == adapter.getChild(groupPosition,childPosition).getStatus()){
                    groups.get(groupPosition).getChilds().get(childPosition).setStatus(1);
                    groups.get(groupPosition).getChilds().get(childPosition).setUserName("修改成功");
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });
    }
}
