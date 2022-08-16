package edu.njit.littmanlibrary.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.njit.littmanlibrary.R;
import edu.njit.littmanlibrary.helpers.HorizontalScrollListView;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        HorizontalScrollListView listview1 = (HorizontalScrollListView) root.findViewById(R.id.listview1);
        HomeAdapter mAdapter = new HomeAdapter(getActivity(), publications);
        listview1.setAdapter(mAdapter);
        HorizontalScrollListView listview2 = (HorizontalScrollListView) root.findViewById(R.id.listview2);
        mAdapter = new HomeAdapter(getActivity(), events);
        listview2.setAdapter(mAdapter);

        return root;
    }

    private static Entry[] publications = new Entry[]{
            new Entry("one", "Text #1"),
            new Entry("two", "Text #2"),
            new Entry("three", "Text #3"),
            new Entry("four", "Text #4")};

    private static Entry[] events = new Entry[]{
            new Entry("five", "Music in the Library Event"),
            new Entry("six", "Book Talk with Rima Taher"),
            new Entry("seven", "The World of Robotics"),
            new Entry("eight", "INTERNATIONAL TEA WITH ALUMNI")};

    public class HomeAdapter extends BaseAdapter {
        Entry[] dataObjects;

        public HomeAdapter(Context context, Entry[] dataObjects) {
            this.dataObjects = dataObjects;
        }

        @Override
        public int getCount() {
            return dataObjects.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, null);
            TextView title = (TextView) retval.findViewById(R.id.title);
            ImageView image = (ImageView) retval.findViewById(R.id.image);
            int resourceId = getResources().getIdentifier(dataObjects[position].image, "drawable", getActivity().getPackageName());
            image.setImageResource(resourceId);
            title.setText(dataObjects[position].title);

            return retval;
        }

    };

    private static class Entry {
        String image = "";
        String title = "";

        public Entry(String image, String title) {
            this.image = image;
            this.title = title;
        }
    }
}