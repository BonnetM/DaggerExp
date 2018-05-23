package m.bonnet.daggerexp.async

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlin.coroutines.experimental.CoroutineContext

abstract class LifecycleAwareController(lifecycleOwner: LifecycleOwner,
                                        private val coroutineContext: CoroutineContext = CommonPool) {
    private val parentJob = Job()

    init {
        lifecycleOwner.lifecycle.addObserver(ActorLifecycleObserver(parentJob))
    }

    protected fun <T> consumerActor(argument: T, capacity: Int = 0, start: CoroutineStart = CoroutineStart.DEFAULT, block: (T) -> Unit) =
            actor<T>(parent = parentJob, context = coroutineContext, capacity = capacity, start = start) { channel.consumeEach {
                block(it)
            }
            }
                    .offer(argument)
}


class ActorLifecycleObserver(private val job: Job) : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        if (!job.isCancelled) job.cancel()
    }
}