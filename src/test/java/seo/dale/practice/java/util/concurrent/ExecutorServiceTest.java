package seo.dale.practice.java.util.concurrent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ExecutorServiceTest {
    private static final String TEST = "TEST";

    private ExecutorService executorService;

    @Mock
    private Callable<String> callable;

    @Before
    public void setUp() throws Exception {
        when(callable.call()).thenAnswer(invocation -> {
            Thread.sleep(1000);
            return TEST;
        });
        executorService = Executors.newSingleThreadExecutor();
    }

    @Test
    public void mustCallCallableTask() throws Exception {
        Future<String> future = executorService.submit(callable);

        assertThat(future.get()).isSameAs(TEST);
        verify(callable).call();
    }

    @Test
    public void mustInvokeAllCallableTasks() throws Exception {
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(callable, callable, callable));

        for (Future future : futures) {
            assertThat(future.get()).isSameAs(TEST);
        }
        verify(callable, times(3)).call();
    }

    @Test(expected = RejectedExecutionException.class)
    public void mustThrowRejectedExecutionExceptionAfterShutdownCalled() throws Exception {
        executorService.shutdown();
        executorService.submit(callable);
        fail();
    }
}
