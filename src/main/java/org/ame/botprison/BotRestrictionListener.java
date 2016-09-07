package org.ame.botprison;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;
import org.spigotmc.event.entity.EntityMountEvent;

/**
 * Event listener that prevents most actions of a bot.
 */
public class BotRestrictionListener implements Listener {
    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER && ConfigManager.isBot((Player) event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityMount(EntityMountEvent event) {
        if (event.getEntityType() == EntityType.PLAYER && ConfigManager.isBot((Player) event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityElytraToggle(EntityToggleGlideEvent event) {
        if (event.getEntityType() == EntityType.PLAYER && ConfigManager.isBot((Player) event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntityType() == EntityType.PLAYER && ConfigManager.isBot(event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {
        if (ConfigManager.isBot(event.getEnchanter())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryInteract(InventoryInteractEvent event) {
        if (ConfigManager.isBot(event.getWhoClicked())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPrepareItemEnchant(PrepareItemEnchantEvent event) {
        if (ConfigManager.isBot(event.getEnchanter())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerBucket(PlayerBucketEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerEditBook(PlayerEditBookEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerShearEntity(PlayerShearEntityEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleSneakEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerLeashEntity(PlayerLeashEntityEvent event) {
        if (ConfigManager.isBot(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
}
