package com.example.app_readbook.readbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.app_readbook.R;

import java.util.ArrayList;
import java.util.List;

public class MainReadbook extends AppCompatActivity {
private TextView btn_back , btn_next , txt_book , txt_book_all;
private ViewPager viewPager;
private List<ReadbookName> readbookNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readbook);
        iniU();
        readbookNames = getReadbook();
        ReadbookAdaptor readbookAdaptor = new ReadbookAdaptor(getSupportFragmentManager() , FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT , readbookNames);
        viewPager.setAdapter(readbookAdaptor);
        txt_book.setText("1");
        txt_book_all.setText(String.valueOf(readbookNames.size()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                txt_book.setText(String.valueOf(position + 1 ));
                if (position == 0)
                {
                    btn_back.setVisibility(View.GONE);
                    btn_next.setVisibility(View.VISIBLE);
                } else if (position == readbookNames.size() - 1)
                {
                    btn_back.setVisibility(View.VISIBLE);
                    btn_next.setVisibility(View.GONE);
                } else {
                    btn_back.setVisibility(View.VISIBLE);
                    btn_next.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
    }

    private List<ReadbookName> getReadbook() {
        List<ReadbookName> list = new ArrayList<>();
        for(int i = 1 ; i<=10 ; i++)
        {
            list.add(new ReadbookName("Trang" +i));
        }
        return  list;
    }

    private void iniU() {
        btn_back = findViewById(R.id.before);
        btn_next  = findViewById(R.id.next);
        txt_book = findViewById(R.id.txt1);
        txt_book_all = findViewById(R.id.txt2);
        viewPager = findViewById(R.id.viewpager);
    }

}