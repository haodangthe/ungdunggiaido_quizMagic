package com.example.ungdunggiaido_quizmagic.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ungdunggiaido_quizmagic.fragment.DoiThuongFragment;
import com.example.ungdunggiaido_quizmagic.fragment.XepHangFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new XepHangFragment();
            case 1:
                return new DoiThuongFragment();
        }
        return new XepHangFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Xếp Hạng";
                break;
            case 1:
                title = "Đổi Thưởng";
                break;
        }
        return title;
    }
}
