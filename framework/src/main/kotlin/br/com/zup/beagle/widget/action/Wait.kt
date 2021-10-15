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

package br.com.zup.beagle.widget.action

import br.com.zup.beagle.analytics.ActionAnalyticsConfig
import br.com.zup.beagle.widget.context.Bind
import br.com.zup.beagle.widget.context.constant

data class Wait(
    val time: Bind<Int>,
    val onFinish: List<Action>? = null,
    override var analytics: ActionAnalyticsConfig? = null
) : AnalyticsAction {
    constructor(
        time: Int,
        onFinish: List<Action>? = null,
        analytics: ActionAnalyticsConfig? = null
    ) : this(
        time = constant(time),
        onFinish = onFinish,
        analytics = analytics
    )
}