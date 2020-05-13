package com.tinaking.events;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {
    @EventHandler
    public void login(PlayerLoginEvent e) {
        double val = 16.0;

        AttributeInstance instance = e.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED);
        if (instance == null) throw new RuntimeException("PVPCooldown failed to get player attributes.");
        instance.setBaseValue(val);
        e.getPlayer().saveData();
    }

    @EventHandler
    public void logout(PlayerQuitEvent e) {
        double val = 4.0;

        AttributeInstance instance = e.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED);
        if (instance == null) throw new RuntimeException("PVPCooldown failed to get player attributes.");
        instance.setBaseValue(val);
        e.getPlayer().saveData();
    }
}
