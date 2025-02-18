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

package br.com.zup.beagle.widget.form

import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.action.Action
import br.com.zup.beagle.widget.context.Context
import br.com.zup.beagle.widget.context.ContextComponent

/**
 * Component will define a submit handler for a SimpleForm.
 *
 * @param context define the context that be set to form
 *
 * @param children define the items on the simple form.
 *
 * @param onSubmit define the actions you want to execute when action submit form
 * @param onValidationError this event is executed every time a form is submitted,
 * but because of a validation error, the onSubmit event is not run.
 *
 */
class SimpleForm(
    override val context: Context? = null,
    val onSubmit: List<Action>,
    val children: List<ServerDrivenComponent>? = null,
    val onValidationError: List<Action>? = null,
) : Widget(), ContextComponent
