/*
 * Copyright 2014-2016 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kotcrab.vis.plugin.spriter.system;

import com.google.common.eventbus.Subscribe;
import com.kotcrab.vis.editor.module.EventBusSubscriber;
import com.kotcrab.vis.editor.module.scene.SceneModule;
import com.kotcrab.vis.editor.plugin.api.ContainerExtension;
import com.kotcrab.vis.plugin.spriter.event.SpriterResourcesReloadedEvent;
import com.kotcrab.vis.runtime.plugin.VisPlugin;

/** @author Kotcrab */
@VisPlugin
@EventBusSubscriber
public class SpriterReloaderModule extends SceneModule implements ContainerExtension {
	private SpriterReloaderManager spriterReloaderManager;

	@Override
	public ExtensionScope getScope () {
		return ExtensionScope.SCENE;
	}

	@Subscribe
	public void handleResourceReloaded (SpriterResourcesReloadedEvent event) {
		spriterReloaderManager.reloadSpriterData();
	}
}