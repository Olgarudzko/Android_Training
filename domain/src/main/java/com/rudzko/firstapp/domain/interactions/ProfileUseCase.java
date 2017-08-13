package com.rudzko.firstapp.domain.interactions;

import com.rudzko.firstapp.domain.entity.Profile;
import com.rudzko.firstapp.domain.entity.ProfileId;
import com.rudzko.firstapp.domain.interactions.base.UseCase;

/**
 * @author Olga Rudzko;
 */

public class ProfileUseCase extends UseCase<ProfileId, Profile>{

    @Override
    protected Profile buildUseCase() {
        Profile profile=new Profile();
        profile.setName("User from domain");
        profile.setAge(25);
        return profile;
    }

    @Override
    protected Profile buildUseCase(ProfileId id) {
        return null;
    }
}
