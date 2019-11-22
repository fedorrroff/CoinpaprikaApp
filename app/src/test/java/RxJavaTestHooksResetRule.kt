import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description

class RxJavaTestHooksResetRule @JvmOverloads constructor(
    val scheduler: Scheduler = Schedulers.trampoline()
) : TestRule {


    override fun apply(
        base: org.junit.runners.model.Statement?,
        description: Description?
    ): org.junit.runners.model.Statement = object : org.junit.runners.model.Statement(){
            override fun evaluate() {
                RxJavaPlugins.setIoSchedulerHandler { scheduler }
                RxJavaPlugins.setComputationSchedulerHandler { scheduler }
                RxJavaPlugins.setNewThreadSchedulerHandler { scheduler }
                RxAndroidPlugins.setMainThreadSchedulerHandler { scheduler }
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler }
                try {
                    base?.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                    RxAndroidPlugins.reset()
                }
            }
        }
}