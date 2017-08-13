package com.rudzko.firstapp.domain.interactions;

import com.rudzko.firstapp.domain.entity.AvatarGalleryItem;
import com.rudzko.firstapp.domain.entity.AvatarId;
import com.rudzko.firstapp.domain.interactions.base.UseCase;

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

    @Override
    protected AvatarGalleryItem buildUseCase() {
        return null;
    }

    @Override
    protected AvatarGalleryItem buildUseCase(AvatarId id) {
        AvatarGalleryItem item=new AvatarGalleryItem();
        item.setUrl(contents[id.getId()]);
        return item;
    }
}
