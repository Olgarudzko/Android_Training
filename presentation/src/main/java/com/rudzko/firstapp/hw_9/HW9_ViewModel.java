package com.rudzko.firstapp.hw_9;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.domain.entity.AvatarGalleryItem;
import com.rudzko.firstapp.domain.entity.AvatarId;
import com.rudzko.firstapp.domain.interactions.AvatarUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * @author Olga Rudzko
 */

public class HW9_ViewModel implements BaseViewModel {

    public ItemViewModel[] items = new ItemViewModel[12];
    private AvatarUseCase useCase = new AvatarUseCase();
    private DisposableObserver observer;
    @Override
    public void init() {

        for (int i = 0; i < 12; i++) {
            final AvatarId id = new AvatarId();
            id.setId(i);
            useCase.execute(id, new DisposableObserver<AvatarGalleryItem>() {

                ItemViewModel pic;
                int number = id.getId();

                @Override
                public void onNext(@NonNull AvatarGalleryItem avatarGalleryItem) {
                    pic = new ItemViewModel(avatarGalleryItem.getUrl());
                    items[number] = pic;
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.e("ERROR!!!", "onExecute", e);
                }

                @Override
                public void onComplete() {
                }
            });
        }
    }


    @Override
    public void resume() {


    }

    @Override
    public void release() {

    }


    @Override
    public void pause() {

        }

}
