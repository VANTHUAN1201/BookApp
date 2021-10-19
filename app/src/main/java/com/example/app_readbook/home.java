package com.example.app_readbook;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.app_readbook.Name_book.Name;
import com.example.app_readbook.Name_book.NameBookAdaptor;
import com.example.app_readbook.book.book;
import com.example.app_readbook.fragment.PhotoAdaptor;
import com.example.app_readbook.fragment.ViewPagerAdaptor2;
import com.example.app_readbook.fragment.photo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class home extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NameBookAdaptor nameBookAdaptor;
    private ViewPager2 viewPager2 , view;
private LinearLayout relativeLayout;
    private BottomNavigationView bottomNavigationView;
    private CircleIndicator3 indicator;
    private List<photo> mlist;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

            int currentPosition =  view.getCurrentItem();
            if(currentPosition == mlist.size()  - 1 )
            {
                view.setCurrentItem(0);
            }else {
                view.setCurrentItem(currentPosition + 1);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_home);
        viewPager2 = findViewById(R.id.viewview);
        view = findViewById(R.id.view_2);
        relativeLayout = findViewById(R.id.rl);
        indicator  = findViewById(R.id.cr);
        mlist = getListphoto();
        bottomNavigationView = findViewById(R.id.btn_navigatione);
        ViewPagerAdaptor2 viewPagerAdaptor2 = new ViewPagerAdaptor2(this);
        viewPager2.setAdapter(viewPagerAdaptor2);
        PhotoAdaptor photoAdaptor = new PhotoAdaptor(mlist);
        view.setAdapter(photoAdaptor);
        indicator.setViewPager(view);
        // recyclerView
        recyclerView = findViewById(R.id.rcv_name);
        nameBookAdaptor = new NameBookAdaptor(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this , RecyclerView.VERTICAL , false);
        recyclerView.setLayoutManager(linearLayoutManager);
        nameBookAdaptor.setData(getListName());
        recyclerView.setAdapter(nameBookAdaptor);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.btn_home:
                        viewPager2.setCurrentItem(0);
                    view.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                    break;
                    case R.id.btn_search:
                        viewPager2.setCurrentItem(1);
                        view.setVisibility(View.GONE);
                        relativeLayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        break;
                    case R.id.btn_favorite:
                        viewPager2.setCurrentItem(2);
                        view.setVisibility(View.GONE);
                        relativeLayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        break;
                    case R.id.btn_account:
                        viewPager2.setCurrentItem(3);
                        view.setVisibility(View.GONE);
                        relativeLayout.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        break;

                }
                return true;
            }
        });
        view.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
               super.onPageSelected(position);
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable , 3000);


            }
        });
    }


    public List<photo> getListphoto() {
        List<photo> list = new ArrayList<>();
        list.add(new photo(R.drawable.sachhome));
        list.add(new photo(R.drawable.nenxanhla));
        list.add(new photo(R.drawable.nenvang));
        list.add(new photo(R.drawable.nenhong));
        return list;
    }
    private List<Name> getListName() {
        List<Name> ls = new ArrayList<>();
        List<book> list = new ArrayList<>();
        list.add(new book(R.drawable.sach1 , "Book 1"));
        list.add(new book(R.drawable.sach1 , "Book 2"));
        list.add(new book(R.drawable.sach1 , "Book 3"));
        list.add(new book(R.drawable.sach1 , "Book 4"));
        list.add(new book(R.drawable.sach1 , "Book 5"));
        list.add(new book(R.drawable.sach1 , "Book 1"));
        list.add(new book(R.drawable.sach1 , "Book 2"));
        list.add(new book(R.drawable.sach1 , "Book 3"));
        list.add(new book(R.drawable.sach1 , "Book 4"));
        list.add(new book(R.drawable.sach1 , "Book 5"));
        ls.add(new Name("Sách Kinh Doanh" ,"(10)","xem tất cả", list));
        ls.add(new Name("Sách Khoa Học","(10)","xem tất cả" ,list));
        ls.add(new Name("Sách Làm Giàu" ,"(10)","xem tất cả",list));
        return ls;
    }
}