package com.rudzko.firstapp.domain.interactions;

import com.rudzko.firstapp.data.entity.SourceProfile;
import com.rudzko.firstapp.data.net.RestService;
import com.rudzko.firstapp.domain.entity.Profile;
import com.rudzko.firstapp.domain.interactions.base.UseCase;

import io.reactivex.Observable;

/**
 * @author Olga Rudzko
 */

public class UpdateProfileUseCase extends UseCase<Profile, Void> {
    @Override
    protected Observable<Void> buildUseCase(Profile profile) {
        SourceProfile sprof=new SourceProfile();
        sprof.setName(profile.getName());
        sprof.setAge(profile.getAge());
        sprof.setId(profile.getId().getId());
        return RestService.getInstance().updateProfile(sprof);
    }
}
