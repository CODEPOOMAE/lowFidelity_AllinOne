package coms.example.allinonelowfiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import coms.example.allinonelowfiproject.ExerciseDiary.BeforeAndAfter.BeforeAndAfterFragment;
import coms.example.allinonelowfiproject.ExerciseDiary.BodyPlan.BodyPlanFragment;
import coms.example.allinonelowfiproject.ExerciseDiary.ExerciseSetting.ExerciseSettingFragment;
import coms.example.allinonelowfiproject.ExerciseDiary.Monthly.MonthlyFragment;
import coms.example.allinonelowfiproject.ExerciseDiary.Today.TodayFragment;

public class ExerciseDiaryMainActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        BeforeAndAfterFragment beforeAndAfterFragment = new BeforeAndAfterFragment();
        BodyPlanFragment bodyPlanFragment = new BodyPlanFragment();
        ExerciseSettingFragment exerciseSettingFragment = new ExerciseSettingFragment();
        MonthlyFragment monthlyFragment = new MonthlyFragment();
        TodayFragment todayFragment = new TodayFragment();

        Log.e("ExerciseDiary","onCreat");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_diary);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host,beforeAndAfterFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.navigation_beforeandafter:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host,beforeAndAfterFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case R.id.navigation_bodyplan:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host,bodyPlanFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case R.id.navigation_Setting:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host,exerciseSettingFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case R.id.navigation_monthly:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host,monthlyFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case R.id.navigation_today:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host,todayFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                }

                return false;
            }
        });


    }
}