package com.rudzko.firstapp.hw_9;

import android.content.Context;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.domain.entity.AvatarGalleryItem;
import com.rudzko.firstapp.domain.entity.AvatarId;
import com.rudzko.firstapp.domain.interactions.AvatarUseCase;

/**
 * @author Olga Rudzko
 */

public class HW9_ViewModel implements BaseViewModel{

    private Context context;
    public ItemViewModel[] items=new ItemViewModel[12];
    private AvatarUseCase useCase = new AvatarUseCase();

    @Override
    public void init() {

    }

    @Override
    public void resume() {
        for (int i=0; i<12; i++){
            AvatarId id=new AvatarId();
            id.setId(i);
            AvatarGalleryItem item=useCase.execute(id);
            ItemViewModel picture=new ItemViewModel(item.getUrl());
            items[i]=picture;
        }
    }

    @Override
    public void release() {

    }


    @Override
    public void pause() {

    }

}
