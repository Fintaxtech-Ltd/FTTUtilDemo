package uk.co.fintaxtech.ftt.utils.coroutines

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

class FTTRepositoryResultTest {

    @Test
    fun repositoryResult_blockSucceeds_returnsSuccessResult() = runTest {
        val result = repositoryResult { "value" }

        assertEquals("value", result.getOrNull())
    }

    @Test
    fun repositoryResult_blockThrows_returnsFailureResult() = runTest {
        val exception = IllegalStateException("boom")

        val result = repositoryResult<Unit> { throw exception }

        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }

    @Test
    fun repositoryResult_blockCancelled_propagatesCancellation() {
        assertThrows(CancellationException::class.java) {
            runBlocking {
                repositoryResult<Unit> { throw CancellationException("cancelled") }
            }
        }
    }
}
