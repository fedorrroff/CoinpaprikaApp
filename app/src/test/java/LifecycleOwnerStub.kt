import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class LifecycleOwnerStub : LifecycleOwner {
    private val lifecycleRegistryStub = LifecycleRegistryStub(this)

    override fun getLifecycle(): LifecycleRegistry = lifecycleRegistryStub

    fun hasObserver(observer: LifecycleObserver) = lifecycleRegistryStub.checkObserverWasAdded(observer)
}