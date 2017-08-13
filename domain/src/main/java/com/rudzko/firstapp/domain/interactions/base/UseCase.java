package com.rudzko.firstapp.domain.interactions.base;

/**
 * @author Olga Rudzko
 */

public abstract class UseCase<InParam, OutParam> {

    protected abstract OutParam buildUseCase();
    protected abstract OutParam buildUseCase(InParam param);

    public OutParam execute (InParam param){
        return buildUseCase()!=null ? buildUseCase() : buildUseCase(param);
    }
}
