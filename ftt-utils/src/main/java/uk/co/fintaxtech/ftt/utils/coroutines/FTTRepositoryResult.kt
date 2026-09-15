package uk.co.fintaxtech.ftt.utils.coroutines

import kotlinx.coroutines.CancellationException

/** Runs a suspending repository write as a [Result] without swallowing coroutine cancellation. */
suspend fun <T> repositoryResult(block: suspend () -> T): Result<T> = try {
    Result.success(block())
} catch (exception: CancellationException) {
    throw exception
} catch (exception: Exception) {
    Result.failure(exception)
}
