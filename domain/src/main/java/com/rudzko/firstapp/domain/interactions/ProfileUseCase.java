package com.rudzko.firstapp.domain.interactions;

import com.rudzko.firstapp.data.entity.SourceProfile;
import com.rudzko.firstapp.data.net.RestService;
import com.rudzko.firstapp.domain.entity.Profile;
import com.rudzko.firstapp.domain.entity.ProfileId;
import com.rudzko.firstapp.domain.interactions.base.UseCase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * @author Olga Rudzko;
 */

public class ProfileUseCase extends UseCase<ProfileId, Profile> {

    @Override
    protected Observable<Profile> buildUseCase(ProfileId Param) {

        return RestService.getInstance().getSourceProfiles().map(new Function<List<SourceProfile>, Profile>() {
            @Override
            public Profile apply(@NonNull List<SourceProfile> sourceProfiles) throws Exception {
                SourceProfile data=sourceProfiles.get(0);
                return new Profile(data.getName(), data.getAge());
            }
        });
    }
}





//TO LEARN!!! Observable methods:
// .filter - method for getting only desired (wich match special conditions) pieces of information
// .flatMap
// .flat
// .subscribeWith
