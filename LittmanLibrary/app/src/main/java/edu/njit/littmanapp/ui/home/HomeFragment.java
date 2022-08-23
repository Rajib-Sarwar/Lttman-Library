package edu.njit.littmanapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.io.Serializable;

import edu.njit.littmanapp.R;
import edu.njit.littmanapp.ui.helper.HorizontalScrollListView;

public class HomeFragment extends Fragment {
    SharedPreferences prefs;
    boolean isLargeFont;
    boolean isDarkMode;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        HorizontalScrollListView listview1 = root.findViewById(R.id.listview1);
        HomeAdapter mAdapter = new HomeAdapter(getActivity(), publications);
        listview1.setAdapter(mAdapter);

        HorizontalScrollListView listview2 = root.findViewById(R.id.listview2);
        mAdapter = new HomeAdapter(getActivity(), events);
        listview2.setAdapter(mAdapter);

        TextView seemorePublication = root.findViewById(R.id.see_more_publication);
        seemorePublication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VerticalActivity.class);
                intent.putExtra("intentList", publications);
                startActivity(intent);
            }
        });

        TextView seemoreEvent = root.findViewById(R.id.see_more_event);
        seemoreEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VerticalActivity.class);
                intent.putExtra("intentList", events);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateFontSize(isLargeFont);

//        isLargeFont = prefs.getBoolean(IS_LARGE_FONT, false);
//        isDarkMode = prefs.getBoolean(IS_DARK_MODE, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    void updateFontSize(boolean isLarge) {
//        tvHeader.setTextSize(TypedValue.COMPLEX_UNIT_DIP, isLarge ? 24 + LARGE_SIZE : 24);
    }

    private static Entry[] publications = new Entry[]{
            new Entry("one", "Text #1"),
            new Entry("two", "Text #2"),
            new Entry("three", "Text #3"),
            new Entry("four", "Text #4")};

    private static Entry[] events = new Entry[]{
            new Entry("five", "Music in the Library Event", "Join us on October 14, 2021 at 7PM at the Littman Library, 4th floor of HCAD for a music event."),
            new Entry("six", "Book Talk with Rima Taher", "Join us on October 6, 2021 at 12PM at the Littman Library for our Book Talk with Rima Taher."),
            new Entry("seven", "The World of Robotics", "The \"World of Robotics\" virtual exhibition presents the work of faculty, staff, and students from Hillier College of Architecture and Design, College of Science and Liberals Arts, and Ying Wu College of Computing."),
            new Entry("eight", "INTERNATIONAL TEA WITH ALUMNI", "\"Our guests: Dr.Martin Kaftan, Nandy Lima, and Dr. Fathia Emelghavi \"")};

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
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, null);
            ImageView image = (ImageView) retval.findViewById(R.id.image);
            TextView title = (TextView) retval.findViewById(R.id.title);
            TextView detail = (TextView) retval.findViewById(R.id.detail);
            int resourceId = getResources().getIdentifier(dataObjects[position].image, "drawable", getActivity().getPackageName());
            image.setImageResource(resourceId);
            title.setText(dataObjects[position].title);
            detail.setText(dataObjects[position].detail);
            return retval;
        }

    };
}

class Entry implements Serializable {
    String image = "";
    String title = "";
    String detail = "";

    public Entry(String image, String title) {
        this.image = image;
        this.title = title;
    }

    public Entry(String image, String title, String detail) {
        this.image = image;
        this.title = title;
        this.detail = detail;
    }
}