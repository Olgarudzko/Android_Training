package com.rudzko.firstapp.domain.entity;

/**
 * @author Olga Rudzko
 */

public class AvatarGalleryItem {
    private String url;

    public AvatarGalleryItem() {
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {

        return url;
    }

    public AvatarGalleryItem(String url) {
        this.url = url;
    }
}
