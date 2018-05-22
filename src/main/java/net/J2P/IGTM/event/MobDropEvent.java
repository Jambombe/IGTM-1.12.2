package net.J2P.IGTM.event;

import net.J2P.IGTM.item.ModItems;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropEvent {

    private final double COMMON_DROP_CHANCE = 0.5;
    private final double RARE_DROP_CHANCE = 0.2;

    @SubscribeEvent
    public void dropEvent(LivingDeathEvent e)
    {
        // Evite les ghost item (World = server) ET vérifie si le killer est un joueur
        if (! e.getEntity().getEntityWorld().isRemote
                && e.getSource().getTrueSource() instanceof EntityPlayer)
        {
            // DROP DRAGON
            if (e.getEntityLiving() instanceof EntityDragon) {
                e.getEntityLiving().dropItem(ModItems.gold_coin, 1);
            }

            // DROP WITHER
            if (e.getEntityLiving() instanceof EntityWither) {
                e.getEntityLiving().dropItem(ModItems.silver_coin, 10);
            }

            // DROP rare : endermen, blazes, gardiens
            if (e.getEntityLiving() instanceof EntityEnderman
                    || e.getEntityLiving() instanceof EntityBlaze
                    || e.getEntityLiving() instanceof EntityGuardian
                    ) {
                double rand = Math.random();

                if (rand > RARE_DROP_CHANCE) {
                    // Drop de 4 à 10 pièces
                    int nbPieces = 4 + (int) (Math.random() * 10);
                    e.getEntityLiving().dropItem(ModItems.copper_coin, nbPieces);
                }
            }

            // DROP common : Zombie, squelette, creeper
            if (e.getEntityLiving() instanceof EntityZombie
                    || e.getEntityLiving() instanceof EntityHusk
                    || e.getEntityLiving() instanceof EntitySkeleton
                    || e.getEntityLiving() instanceof EntityCreeper
                    )
            {
                double rand = Math.random();

                if (rand > COMMON_DROP_CHANCE) {
                    // Drop de 1 à 5 pièces
                    int nbPieces = 1 + (int) (Math.random() * 5);
                    e.getEntityLiving().dropItem(ModItems.copper_coin, nbPieces);
                }
            }
        }
    }


}
