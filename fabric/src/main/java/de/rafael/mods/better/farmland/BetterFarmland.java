/*
 * Copyright (c) 2022. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice,
 *         this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *     * Neither the name of the developer nor the names of its contributors
 *         may be used to endorse or promote products derived from this software
 *         without specific prior written permission.
 *     * Redistributions in source or binary form must keep the original package
 *         and class name.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package de.rafael.mods.better.farmland;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.rafael.mods.better.farmland.callback.UseBlockCallbackListener;
import de.rafael.mods.better.farmland.config.ConfigManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BetterFarmland implements ModInitializer {

	public static String currentVersion = "${version}";

	public static final Logger LOGGER = LoggerFactory.getLogger("betterfarmland");
	public static BetterFarmland INSTANCE;

	private ConfigManager configManager;

	@Override
	public void onInitialize() {
		INSTANCE = this;

		// Loading currently version information
		try(InputStream modFile = this.getClass().getResourceAsStream("/fabric.mod.json")) {
			assert modFile != null;
			JsonObject jsonObject = JsonParser.parseReader(new InputStreamReader(modFile)).getAsJsonObject();
			currentVersion = jsonObject.get("version").getAsString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		LOGGER.info("Loading BetterFarmland version " + currentVersion);
		this.configManager = new ConfigManager();

		int amount = 1;
		while (!this.configManager.load()) {
			amount++;
		}
		LOGGER.info("The config loaded in " + amount + " cycles.");

		// Callbacks
		if(this.configManager.isUseRightClickHarvest()) {
			UseBlockCallback.EVENT.register(new UseBlockCallbackListener());
		}

	}

	public ConfigManager getConfigManager() {
		return configManager;
	}

}
