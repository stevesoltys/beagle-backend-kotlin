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
import br.com.zup.beagle.widget.context.constantNullable

/**
 * will show dialogues natively, such as an error alert indicating alternative flows, business system errors and others.
 *
 * @param title defines the title on the Dialog.
 * @param message defines the Dialog message.
 * @param labelOk define text of button positive in dialog.
 * @param onPressOk define action of button positive in dialog.
 *
 */
data class Alert(
    val title: Bind<String>? = null,
    val message: Bind<String>,
    val onPressOk: List<Action>? = null,
    val labelOk: String? = null,
    override var analytics: ActionAnalyticsConfig? = null
) : AnalyticsAction {
    constructor(
        title: String? = null,
        message: String,
        onPressOk: List<Action>? = null,
        labelOk: String? = null,
        analytics: ActionAnalyticsConfig? = null
    ) : this(
        title = constantNullable(title),
        message = constant(message),
        onPressOk = onPressOk,
        labelOk = labelOk,
        analytics = analytics
    )
}