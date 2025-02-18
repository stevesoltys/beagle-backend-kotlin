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

package br.com.zup.beagle.sample.builder

import br.com.zup.beagle.ext.setId
import br.com.zup.beagle.ext.setStyle
import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.ListDirection
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.core.UnitValue
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.NavigationBar
import br.com.zup.beagle.widget.layout.NavigationBarItem
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.ListView
import br.com.zup.beagle.widget.ui.Template
import br.com.zup.beagle.widget.ui.Text

object ListViewScreenBuilder : ScreenBuilder {
    override fun build() = Screen(
        navigationBar = NavigationBar(
            title = "Beagle ListView",
            showBackButton = true,
            navigationBarItems = listOf(
                NavigationBarItem(
                    text = "",
                    image = "informationImage",
                    action = Alert(
                        title = "ListView",
                        message = "Is a Layout component that will define a list of views natively. " +
                            "These views could be any Server Driven Component.",
                        labelOk = "OK"
                    )
                )
            )
        ),
        child = buildListView()
    )

    private fun buildListView() = ListView(
        context = ContextData(
            id = "outsideContext",
            value = listOf("0 OUTSIDE", "1 OUTSIDE", "2 OUTSIDE", "3 OUTSIDE", "4 OUTSIDE", "5 OUTSIDE",
                "6 OUTSIDE", "7 OUTSIDE", "8 OUTSIDE", "9 OUTSIDE", "10 OUTSIDE",
                "11 OUTSIDE", "12 OUTSIDE", "13 OUTSIDE", "14 OUTSIDE", "15 OUTSIDE",
                "16 OUTSIDE", "17 OUTSIDE", "18 OUTSIDE", "19 OUTSIDE", "20 OUTSIDE")
        ),
        dataSource = expressionOf("@{outsideContext}"),
        direction = ListDirection.VERTICAL,
        templates = listOf(
            Template(
                view = Container(
                    children = listOf(
                        Text(text = expressionOf("@{item}")),
                        list
                    )
                ).setStyle {
                    size = Size(
                        width = UnitValue.percent(100),
                        height = UnitValue.real(600),
                    )
                }
            )
        )
    )

    data class Person(
        val name: String,
        val cpf: Int
    )

    private val list = ListView(
        context = ContextData(
            id = "insideContext",
            value = listOf(
                Person(
                    "John",
                    0
                ),
                Person(
                    "Carter",
                    1
                ),
                Person(
                    "Josie",
                    2
                ),
                Person(
                    "Dimitri",
                    3
                ),
                Person(
                    "Maria",
                    4
                ),
                Person(
                    "Max",
                    5
                ),
                Person(
                    "Kane",
                    6
                ),
                Person(
                    "Amelia",
                    7
                ),
                Person(
                    "Jose",
                    8
                ),
                Person(
                    "Percy",
                    9
                ),
                Person(
                    "Karen",
                    10
                ),
                Person(
                    "Sol",
                    11
                ),
                Person(
                    "Jacques",
                    12
                ),
                Person(
                    "Stephen",
                    13
                ),
                Person(
                    "Sullivan",
                    14
                ),
                Person(
                    "Zoe",
                    15
                )
            )
        ),
        key = "cpf",
        dataSource = expressionOf("@{insideContext}"),
        direction = ListDirection.HORIZONTAL,
        templates = listOf(
            Template(
                view = Container(
                    children = listOf(
                        Button(
                            text = expressionOf("@{item.name} - @{item.cpf}"),
                            onPress = listOf(
                                SetContext(
                                    contextId = "insideContext",
                                    path = "[0].name",
                                    value = "Updated John"
                                )
                            )
                        ).setStyle {
                            size = Size(width = UnitValue.real(300), height = UnitValue.real(80))
                        }.setId("button")
                    )
                ).setId("container")
            )
        )
    ).setStyle {
        backgroundColor = "#CCC"
    }
}
