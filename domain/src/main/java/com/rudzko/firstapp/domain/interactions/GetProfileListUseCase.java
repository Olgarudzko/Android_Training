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

public class GetProfileListUseCase extends UseCase<ProfileId, List<Profile>> {

    @Override
    protected Observable<List<Profile>> buildUseCase(ProfileId param) {
        return RestService.getInstance().getSourceProfiles()
                .map(new Function<List<SourceProfile>, List<Profile>>() {
                    @Override
                    public List<Profile> apply(@NonNull List<SourceProfile> profiles) throws Exception {
                        List<Profile> list = new ArrayList<>();
                        for(SourceProfile profile: profiles) {
                            list.add(
                                    new Profile(profile.getName(), profile.getAge(),
                                            new ProfileId(profile.getId())));
                        }
                        return list;
                    }
                });
    }
}
