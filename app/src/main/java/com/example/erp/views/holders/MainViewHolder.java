package com.example.erp.views.holders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.erp.R;
import com.example.erp.data.models.MainModel;

import butterknife.BindView;

/**
 * Created by zwe on 8/6/17.
 */

public class MainViewHolder extends BaseViewHolder<MainModel> {
    @BindView(R.id.main_image)
    ImageView image;

    @BindView(R.id.main_text)
    TextView title;

    private ControllerMainItem mController;
    private MainModel mModel;

    public MainViewHolder(View itemView, ControllerMainItem controllerMainItem) {
        super(itemView);
        mController = controllerMainItem;

    }

    @Override
    public void bind(MainModel data) {
        mModel = data;
        Glide.with(image.getContext()).load(data.getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).into(image);
        title.setText(data.getTitle());
    }

    @Override
    public void onClick(View view) {
        mController.onMainItemClicked(mModel);
    }

    public interface  ControllerMainItem{
        void onMainItemClicked(MainModel mainModel);
    }
}
