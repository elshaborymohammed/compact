package com.smart.github.app.trend;

import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.compact.app.CompactActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smart.github.R;
import io.reactivex.android.schedulers.AndroidSchedulers;

import javax.inject.Inject;

public class TrendActivity extends CompactActivity {

    @Inject
    ViewModelProvider.Factory factory;

    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.nav_view)
    BottomNavigationView navView;
    @BindView(R.id.list)
    RecyclerView recyclerView;

    private TrendViewModel viewModel;
    private TrendAdapter adapter;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    message.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    message.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    message.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate() {
        viewModel = ViewModelProviders.of(this, factory).get(TrendViewModel.class);

        adapter = new TrendAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.get()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> adapter.swap(it));

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
