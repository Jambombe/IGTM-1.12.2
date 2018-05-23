package net.J2P.IGTM.recipes;

import net.J2P.IGTM.block.ModBlocks;
import net.J2P.IGTM.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void registerAllRecipes()
    {
        registerCraftingRecipes();
        registerSmeltingRecipes();
    }

    public static void registerCraftingRecipes()
    {

    }

    public static void registerSmeltingRecipes()
    {
        GameRegistry.addSmelting(ModBlocks.pure_gold_ore, new ItemStack(ModItems.gold_coin, 1), 2.0F);
        GameRegistry.addSmelting(ModBlocks.pure_silver_ore, new ItemStack(ModItems.silver_coin, 1), 1.5F);
        GameRegistry.addSmelting(ModBlocks.pure_copper_ore, new ItemStack(ModItems.copper_coin, 1), 0.5F);
    }
}
