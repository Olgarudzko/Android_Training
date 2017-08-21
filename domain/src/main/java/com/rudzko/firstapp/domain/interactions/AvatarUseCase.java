package com.rudzko.firstapp.domain.interactions;

import com.rudzko.firstapp.domain.entity.AvatarGalleryItem;
import com.rudzko.firstapp.domain.entity.AvatarId;
import com.rudzko.firstapp.domain.interactions.base.UseCase;

import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Olga Rudzko
 */

public class AvatarUseCase extends UseCase<AvatarId, AvatarGalleryItem> {

    private String[]contents={
            "https://goo.gl/WSudcj",
            "https://goo.gl/oGjY85",
            "https://goo.gl/t6XCvK",
            "https://goo.gl/enH5AL",
            "https://goo.gl/eiXqvq",
            "https://goo.gl/MbCmYJ",
            "https://goo.gl/KsYpRT",
            "https://goo.gl/ZWgihL",
            "https://goo.gl/dnbn5n",
            "https://goo.gl/oaC3dY",
            "https://goo.gl/ZYoJEA",
            "https://goo.gl/CZoLUN"
    };


    private static AtomicInteger i=new AtomicInteger(0);
    @Override
    protected Observable<AvatarGalleryItem> buildUseCase(AvatarId id) {
        AvatarGalleryItem item=new AvatarGalleryItem();
        item.setUrl(contents[i.getAndIncrement()]);
        return Observable.just(item);
    }
}
