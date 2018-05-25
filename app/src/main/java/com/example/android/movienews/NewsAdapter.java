package com.example.android.movienews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(@NonNull Context context, @NonNull List<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView sectionView = (TextView) listItemView.findViewById(R.id.section_name);
        String sectionName = currentNews.getmSectionName();
        sectionView.setText(sectionName);

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        String titleText = currentNews.getmWebTitle();
        titleView.setText(titleText);

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author);
        String authorText = currentNews.getmAuthor();
        if (authorText.equals("Unknown")) {
            authorTextView.setVisibility(View.GONE);
        } else {
            authorTextView.setText(authorText);
        }

        DateTime dateObject = currentNews.getmDate();

        TextView dateView = (TextView) listItemView.findViewById(R.id.date_published);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time_published);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(DateTime dateObject) {
        DateTimeFormatter dateFormat = DateTimeFormat.mediumDate();
        return dateFormat.print(dateObject);
    }

    private String formatTime(DateTime dateObject) {
        DateTimeFormatter timeFormat = DateTimeFormat.shortTime();
        return timeFormat.print(dateObject);
    }
}
