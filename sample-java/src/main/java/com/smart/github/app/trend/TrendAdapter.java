package com.smart.github.app.trend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import com.compact.widget.CompactRecyclerView;
import com.smart.github.domain.model.Trend;

public class TrendAdapter extends CompactRecyclerView.Adapter<Trend, TrendAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false)
        );
    }

    public class ViewHolder extends CompactRecyclerView.ViewHolder<Trend> {

        @BindView(android.R.id.text1)
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        protected void bind(int position, Trend object) {
            name.setText(object.getFullName());
        }
    }
}
