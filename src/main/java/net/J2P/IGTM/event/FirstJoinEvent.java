package net.J2P.IGTM.event;

import net.J2P.IGTM.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class FirstJoinEvent {

    @SubscribeEvent
    public void firstJoin(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        NBTTagCompound entityData = player.getEntityData();
        if(!entityData.getBoolean("joinedBefore")) {
            entityData.setBoolean("joinedBefore", true);
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.gold_coin));
        }
    }

}
