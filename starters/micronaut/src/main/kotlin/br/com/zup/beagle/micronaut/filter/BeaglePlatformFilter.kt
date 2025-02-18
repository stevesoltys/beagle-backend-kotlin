/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.zup.beagle.micronaut.filter

import br.com.zup.beagle.platform.BeaglePlatformUtil
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.OncePerRequestHttpServerFilter
import io.micronaut.http.filter.ServerFilterChain
import io.micronaut.http.server.netty.types.files.NettySystemFileCustomizableResponseType
import io.reactivex.Flowable
import org.reactivestreams.Publisher

@Filter("/**")
@Requirements(Requires(classes = [BeaglePlatformUtil::class]))
class BeaglePlatformFilter(private val objectMapper: ObjectMapper) : OncePerRequestHttpServerFilter() {

    override fun doFilterOnce(request: HttpRequest<*>, chain: ServerFilterChain): Publisher<MutableHttpResponse<*>> {
        val currentPlatform = request.headers.get(BeaglePlatformUtil.BEAGLE_PLATFORM_HEADER)
        request.attributes.put(BeaglePlatformUtil.BEAGLE_PLATFORM_HEADER, currentPlatform)
        return Flowable.fromPublisher(chain.proceed(request))
            .map { wrappedResponse ->
                treatResponse(wrappedResponse, currentPlatform)
                wrappedResponse
            }
    }

    @Suppress("UNCHECKED_CAST")
    private fun treatResponse(wrappedResponse: MutableHttpResponse<*>, currentPlatform: String?) {
        wrappedResponse.body.ifPresent {
            if (it !is NettySystemFileCustomizableResponseType && it !is ByteArray && it !is String) {
                val jsonTree = this.objectMapper.readTree(
                    this.objectMapper.writeValueAsString(it)
                )
                BeaglePlatformUtil.treatBeaglePlatform(
                    currentPlatform,
                    jsonTree
                )
                (wrappedResponse as MutableHttpResponse<String>).body(this.objectMapper.writeValueAsString(jsonTree))
            }
        }
    }
}
