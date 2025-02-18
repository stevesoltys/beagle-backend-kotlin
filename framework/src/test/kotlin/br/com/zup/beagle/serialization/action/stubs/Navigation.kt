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

package br.com.zup.beagle.serialization.action.stubs

import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.NavigationContext
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen

fun makeActionNavigationPushViewJson() =
    """
        {
          "_beagleAction_": "beagle:pushView",
          "route": {
            "screen": {
              "_beagleComponent_": "beagle:screenComponent",
              "child": {
                "_beagleComponent_": "beagle:container"
              }
            }
          },
          "navigationContext": {
            "value": 1
          }
        }
    """

fun makeObjectNavigationPushView() = Navigate.PushView(
    route = Route.Local(
        screen = Screen(child = Container()),
    ),
    navigationContext = NavigationContext(
        value = 1,
    )
)

fun makeActionNavigationPushStackJson() =
    """
        {
          "_beagleAction_": "beagle:pushStack",
          "route": {
            "screen": {
              "_beagleComponent_": "beagle:screenComponent",
              "child": {
                "_beagleComponent_": "beagle:container"
              }
            }
          },
            "navigationContext": {
            "value": 1
          }
        }
    """

fun makeObjectNavigationPushStack() = Navigate.PushStack(
    route = Route.Local(
        screen = Screen(child = Container()),
    ),
    navigationContext = NavigationContext(
        value = 1,
    )
)

fun makeActionNavigationPopStackJson() =
    """
        {
          "_beagleAction_": "beagle:popStack",
          "navigationContext": {
            "value": 1
          }
        }
    """

fun makeObjectNavigationPopStack() = Navigate.PopStack(
    navigationContext = NavigationContext(
        value = 1,
    )
)

fun makeActionNavigationPopViewJson() =
    """
        {
          "_beagleAction_": "beagle:popView",
          "navigationContext": {
            "value": 1
          }
        }
    """

fun makeObjectNavigationPopView() = Navigate.PopView(
    navigationContext = NavigationContext(
        value = 1,
    )
)

fun makeActionNavigationPopToViewJson() =
    """
        {
          "_beagleAction_": "beagle:popToView",
          "route": "1",
          "navigationContext": {
            "value": 1
          }
        }
    """

fun makeObjectNavigationPopToView() = Navigate.PopToView(
    route = "1",
    navigationContext = NavigationContext(
        value = 1,
    )
)

fun makeActionNavigationResetApplicationJson() =
    """
        {
          "_beagleAction_": "beagle:resetApplication",
          "route": {
            "screen": {
              "_beagleComponent_": "beagle:screenComponent",
              "child": {
                "_beagleComponent_": "beagle:container"
              }
            }
          },
          "navigationContext": {
            "value": 1
          }
        }
    """

fun makeObjectNavigationResetApplication() = Navigate.ResetApplication(
    route = Route.Local(
        screen = Screen(child = Container()),
    ),
    navigationContext = NavigationContext(
        value = 1,
    )
)

fun makeActionNavigationResetStackJson() =
    """
        {
          "_beagleAction_": "beagle:resetStack",
          "route": {
            "screen": {
              "_beagleComponent_": "beagle:screenComponent",
              "child": {
                "_beagleComponent_": "beagle:container"
              }
            }
          },
          "navigationContext": {
            "value": 1
          }
        }
    """

fun makeObjectNavigationResetStack() = Navigate.ResetStack(
    route = Route.Local(
        screen = Screen(child = Container()),
    ),
    navigationContext = NavigationContext(
        value = 1,
    )
)