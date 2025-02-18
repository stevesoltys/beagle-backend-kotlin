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

package br.com.zup.beagle.widget.context

/**
 * Context is a variable of any type, including a map that defines a set of key/value pairs.
 * Through bindings, the value of a context can be accessed by any component or action on your scope.
 *
 * @param id a string that later has to be identified.
 * @param value is a parameter (data) of any kind.
 */
data class ContextData(
    override val id: String,
    val value: Any
) : Context