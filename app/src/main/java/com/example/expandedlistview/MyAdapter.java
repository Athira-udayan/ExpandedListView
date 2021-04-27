package com.example.expandedlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseExpandableListAdapter
{
    TextView parentTextView, childTextView;
    Context context;
    List<String>names;
    Map<String,List<String>>movies;
    public MyAdapter(Context context, List<String> names, Map<String, List<String>> movies)
    {
        this.context = context;
        this.names = names;
        this.movies = movies;
    }

    @Override
    public int getGroupCount() {
        return names.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return movies.get(names.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return names.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return movies.get(names.get(groupPosition)).get(childPosition);
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
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        String lang = (String)getGroup(groupPosition);
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.parent,null);

        }
        parentTextView = view.findViewById(R.id.parentList);
        parentTextView.setText(lang);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        String topic = (String)getChild(groupPosition,childPosition);
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child,null);

        }
        childTextView = view.findViewById(R.id.ChildList);
        childTextView.setText(topic);
        return  view;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return false;
    }
}
