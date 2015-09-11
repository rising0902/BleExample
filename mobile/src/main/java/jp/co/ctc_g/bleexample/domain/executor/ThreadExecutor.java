package jp.co.ctc_g.bleexample.domain.executor;

public interface ThreadExecutor {

    void execute(final Runnable runnable);
}
