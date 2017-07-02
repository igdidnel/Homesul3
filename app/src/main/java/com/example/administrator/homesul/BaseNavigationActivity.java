package com.example.administrator.homesul;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

public abstract class BaseNavigationActivity extends AppCompatActivity {



    protected ViewGroup contnetView;
    private DrawerLayout drawerLayout; //햄버거관련임. 이 변수를 추가한 이유는 네비게이션 메뉴의 레이아웃인 DrawerLayout을 받아오기 위해서이다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basenavigation);

       contnetView = (ViewGroup) findViewById(R.id.content);

        final LayoutInflater layoutInflater = getLayoutInflater();
        int layoutId = getLayoutId();
        if(layoutId != 0){
            layoutInflater.inflate(layoutId,contnetView);
        }


        final ActionBar ab = getSupportActionBar();  //ActionBar를 불러와 ab라는 변수에 넣어준다.
        ab.setHomeAsUpIndicator(R.drawable.ic_menu); //ab라는 액션바의 홈에 ic_menu 이미지 세팅 이미지는 햄버거 모양이 되어야 겠지?
        ab.setDisplayHomeAsUpEnabled(true);  //햄버거 버튼이 보이도록 활성화.
    }
    @LayoutRes
    protected abstract int getLayoutId();

//==================================  햄버거 메뉴 클릭시 동작 ======================================


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //BaseNavigationActivity의 부모인 AppCompatActivity에서 상속 받은 함수임.
        switch (item.getItemId()) {
            case android.R.id.home:    //상속받은 이 함수에서 이부분이 햄버거 버튼클릭시 실행되는 부분이다.
                                      //이부분에 네비게이션 메뉴가 나오는 코드를 넣으면 성공이다.
                drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
//==================================================================================================
}
