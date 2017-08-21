package com.rudzko.firstapp.domain.interactions;

import com.rudzko.firstapp.data.entity.SourceProfile;
import com.rudzko.firstapp.data.net.RestService;
import com.rudzko.firstapp.domain.entity.Profile;
import com.rudzko.firstapp.domain.entity.ProfileId;
import com.rudzko.firstapp.domain.interactions.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * @author Olga Rudzko
 */

public class GetProfileUseCase extends UseCase<ProfileId, Profile> {

    @Override
    protected Observable<Profile> buildUseCase(final ProfileId profileId) {
        return RestService.getInstance().getSourceProfiles()
                .map(new Function<List<SourceProfile>, Profile>() {
                    @Override
                    public Profile apply(@NonNull List<SourceProfile> profiles) throws Exception {
                        Profile result = null;
                        for (SourceProfile profile : profiles) {
                            if (profile.getId() == profileId.getId()) {
                                result = new Profile(profile.getName(), profile.getAge(), profileId);
                            }
                        }
                        return result;
                    }
                });
    }
}
