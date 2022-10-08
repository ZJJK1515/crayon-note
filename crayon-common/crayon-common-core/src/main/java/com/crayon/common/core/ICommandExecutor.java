package com.crayon.common.core;

public interface ICommandExecutor<C extends AbstractCommand, R> {

    Result<R> execute(C cmd);

}
