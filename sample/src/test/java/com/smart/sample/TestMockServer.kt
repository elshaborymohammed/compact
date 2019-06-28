package com.smart.sample

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test

class TestMockServer {
    @Test
    @Throws(Exception::class)
    fun test() {
        // Create a MockWebServer. These are lean enough that you can create a new
        // instance for every unit test.
//        val mock:MockRetrofit()


        val mockServer = MockWebServer()
        mockServer.start()

        val mockResponse = MockResponse()
        mockResponse.setResponseCode(200)
        mockResponse.setBody("{}") // sample JSON

        mockServer.enqueue(mockResponse)

//        val mockRequest = mockServer.takeRequest()
//        mockRequest.path // /blogs


        // Shut down the server. Instances cannot be reused.
        mockServer.shutdown()
    }
}
