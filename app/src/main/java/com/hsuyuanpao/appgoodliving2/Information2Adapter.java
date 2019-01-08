package com.hsuyuanpao.appgoodliving2;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class Information2Adapter implements ExpandableListAdapter {
    private List<String> heading_title;
    private HashMap<String, List<String>> child_title;
    private Context context;

    Information2Adapter(Context context, List<String> heading_title, HashMap<String, List<String>> child_title)
    {
        this.context = context;
        this.heading_title = heading_title;
        this.child_title = child_title;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getGroupCount() {
        return heading_title.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child_title.get(heading_title.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return heading_title.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child_title.get(heading_title.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String h_title = (String) this.getGroup(i);
        if(view == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.information2_parent_layout, null);
        }
        TextView textView = view.findViewById(R.id.heading_item);
        //textView.setTypeface(null, Typeface.BOLD);
        textView.setText(h_title);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String c_title = (String) this.getChild(i, i1);
        if(view == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.information2_child_layout, null);
        }
        TextView textView = view.findViewById(R.id.child_item);
        //textView.setTypeface(null, Typeface.BOLD);
        textView.setText(c_title);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int i) {

    }

    @Override
    public void onGroupCollapsed(int i) {

    }

    @Override
    public long getCombinedChildId(long l, long l1) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long l) {
        return 0;
    }
}
