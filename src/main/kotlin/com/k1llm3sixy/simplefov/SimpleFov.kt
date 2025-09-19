package com.k1llm3sixy.simplefov

import com.k1llm3sixy.simplefov.input.KeyInput
import net.fabricmc.api.ClientModInitializer

class SimpleFov : ClientModInitializer {
    override fun onInitializeClient() {
        KeyInput.registerKeyBinds()
    }
}