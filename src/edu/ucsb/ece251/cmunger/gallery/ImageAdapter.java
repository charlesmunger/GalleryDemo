package edu.ucsb.ece251.cmunger.gallery;

import java.lang.reflect.Field;
import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(135, 135));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    static {
    	Field[] fields = R.drawable.class.getDeclaredFields();
    	ArrayList<Integer> arr = new ArrayList<Integer>(fields.length);
    	for (int i = 0; i < fields.length; i++) {
    		try {
    			if(fields[i].getName().startsWith("grid")) {
    				arr.add(fields[i].getInt(null));
    			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	mThumbIds = arr.toArray(new Integer[arr.size()]);
    }
    // references to our images
    public static final Integer[] mThumbIds;
}
