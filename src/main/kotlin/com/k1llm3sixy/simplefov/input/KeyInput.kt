package com.k1llm3sixy.simplefov.input

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import org.lwjgl.glfw.GLFW

const val KEYBIND_CATEGORY = "SimpleFov"
object KeyInput {
    lateinit var keyIncrease: KeyBinding
    lateinit var keyDecrease: KeyBinding

    fun registerKeyBinds() {
        keyIncrease = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "key.increase",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_EQUAL,
                KEYBIND_CATEGORY
            )
        )
        keyDecrease = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "key.decrease",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_MINUS,
                KEYBIND_CATEGORY
            )
        )
        setupKeyBinds()
    }

    fun setupKeyBinds() {
        ClientTickEvents.END_CLIENT_TICK.register {
            val options = it.options
            val fov = options.fov.value
            if (keyIncrease.wasPressed()) options.fov.value = (fov + 1).coerceAtMost(110)
            if (keyDecrease.wasPressed()) options.fov.value = (fov - 1).coerceAtLeast(30)
        }
    }
}