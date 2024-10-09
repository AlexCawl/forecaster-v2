import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

@Serializable
data class Demo(
    val a: Int
)

val a = runBlocking {
    4
}