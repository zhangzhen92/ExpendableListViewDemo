package com.example.zz.myapplication.adpater;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zz.myapplication.R;
import com.example.zz.myapplication.bean.ChildBean;
import com.example.zz.myapplication.bean.GroupBean;

import java.util.List;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2017/8/10 14:50
 */


public class DataAdapter extends BaseExpandableListAdapter{
    private Context mContext;
    private List<GroupBean> mDatas;
    private LayoutInflater inflater;

    public DataAdapter(Context context, List<GroupBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mDatas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mDatas.get(groupPosition).getChilds().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mDatas.get(groupPosition);
    }

    @Override
    public ChildBean getChild(int groupPosition, int childPosition) {
        return mDatas.get(groupPosition).getChilds().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.group_item,null);
            viewHolder = new GroupViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (GroupViewHolder) convertView.getTag();
        }
        if(!TextUtils.isEmpty(mDatas.get(groupPosition).getName())){
            viewHolder.textGroupName.setText(mDatas.get(groupPosition).getName());
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       ChildViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.child_item,null);
            viewHolder = new ChildViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ChildViewHolder) convertView.getTag();
        }
         if(!TextUtils.isEmpty(mDatas.get(groupPosition).getChilds().get(childPosition).getUserName())){
             viewHolder.textChildName.setText(mDatas.get(groupPosition).getChilds().get(childPosition).getUserName());
         }
        int status = mDatas.get(groupPosition).getChilds().get(childPosition).getStatus();
        if(0== status){
            viewHolder.relativeParent.setBackgroundColor(Color.GRAY);
        }else if(1 == status){
            viewHolder.relativeParent.setBackgroundColor(Color.LTGRAY);
        }else if(2 == status){
            viewHolder.relativeParent.setBackgroundColor(Color.parseColor("#A1A1A1"));
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;                                                       //TODO  返回true子类点击才有效果
    }


    /**
     * GroupViewHold类
     */
    class GroupViewHolder{
        private TextView textGroupName;
        public GroupViewHolder(View convertView){
            textGroupName = ((TextView) convertView.findViewById(R.id.textview_group_title));
        }
    }

    class ChildViewHolder{
        private TextView textChildName;
        private RelativeLayout relativeParent;
        public ChildViewHolder(View convertView){
            textChildName = ((TextView) convertView.findViewById(R.id.textview_child_title));
            relativeParent = ((RelativeLayout) convertView.findViewById(R.id.relative_parent));
        }
    }
}
