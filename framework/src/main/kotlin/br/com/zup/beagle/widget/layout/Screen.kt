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

package br.com.zup.beagle.widget.layout

import br.com.zup.beagle.core.Accessibility
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.widget.action.Action
import br.com.zup.beagle.widget.context.Bind
import br.com.zup.beagle.widget.context.Context
import br.com.zup.beagle.widget.context.ContextComponent
import br.com.zup.beagle.widget.context.constantNullable
import br.com.zup.beagle.widget.ui.Image

/**
 * The SafeArea will enable Safe areas to help you place your views within the visible portion of the overall interface.
 * <p>
 * Note: This class is only used to iOS SafeArea
 * </p>
 *
 * @param top enable the safeArea constraint only on the TOP of the screen view.
 * @param leading enable the safeArea constraint only on the LEFT side of the screen view.
 * @param bottom enable the safeArea constraint only on the BOTTOM of the screen view.
 * @param trailing enable the safeArea constraint only on the RIGHT of the screen view.
 *
 */
data class SafeArea(
    val top: Boolean? = null,
    val leading: Boolean? = null,
    val bottom: Boolean? = null,
    val trailing: Boolean? = null
)

/**
 *  Defines a list of navigation bar items.
 *
 * @see Accessibility
 *
 * @param text defines the description for the item
 * @param image defines the image for the item
 * @param action defines an action to be called when the item is clicked on
 * @param accessibility defines the accessibility details for the item
 *
 */
data class NavigationBarItem(
    val text: String,
    val image: Image? = null,
    val action: Action,
    val accessibility: Accessibility? = null
)

/**
 *  Typically displayed at the top of the window, containing buttons for navigating within a hierarchy of screens
 *
 * @see Accessibility
 * @see NavigationBarItem
 *
 * @param title define the Title on the navigation bar
 * @param showBackButton enable a back button into your action bar/navigation bar
 * @param styleId could define a custom layout for your action bar/navigation  bar
 * @param navigationBarItems defines a List of navigation bar items.
 * @param backButtonAccessibility define accessibility details for the item
 *
 */
data class NavigationBar(
    val title: String? = null,
    val showBackButton: Boolean = true,
    val styleId: String? = null,
    val navigationBarStyle: NavigationBarStyle? = null,
    val navigationBarItems: List<NavigationBarItem>? = null,
    val searchBar: SearchBar? = null,
    val backButtonAccessibility: Accessibility? = null
)

data class NavigationBarStyle(
    val backgroundColor: String? = null,
    val textColor: String? = null,
    val textSize: String? = null,
    val tintColor: String? = null,
    val isShadowEnabled: Boolean? = null,
    val isTransparent: Boolean? = null,
    val titleImage: Image? = null
)

data class SearchBar(
    val placeholder: String? = null,
    val hideWhenScrolling: Boolean? = null,
    val onQueryUpdated: List<Action>? = null
)

/**
 * The screen element will help you define the screen view structure.
 * By using this component you can define configurations like whether or
 * not you want to use safe areas or display a tool bar/navigation bar.
 *
 * @see NavigationBar
 * @see ServerDrivenComponent
 * @see Style
 *
 * @param id use to identifier the current view
 * @param safeArea
 *                      enable Safe areas to help you place your views within the visible
 *                      portion of the overall interface.
 *                      By default it is not enabled and it wont constrain considering any safe area.
 * @param navigationBar enable a action bar/navigation bar into your view. By default it is set as null.
 * @param child
 *                  define the child elements on this screen.
 *                  It could be any visual component that extends the ServerDrivenComponent.1
 * @param style enable a few visual options to be changed.
 * @param context define the context that be set to screen.
 *
 */
data class Screen(
    val id: String? = null,
    val safeArea: SafeArea? = null,
    val navigationBar: NavigationBar? = null,
    val child: ServerDrivenComponent,
    val style: Style? = null,
    override val context: Context? = null
) : ContextComponent