package fr.cleboost.createcoffeefactory.item;

import javax.annotation.Nonnull;

import fr.cleboost.createcoffeefactory.core.CCFItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CoffeeCupItem extends Item {
    private static final int MAX_DURABILITY = 10;

    public CoffeeCupItem(Properties properties) {
        super(properties.durability(MAX_DURABILITY));
    }

    @Override
    @Nonnull
    public ItemStack finishUsingItem(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull LivingEntity entity) {
        if (entity instanceof Player player) {
            int newDamage = stack.getDamageValue() + 1;
            stack.setDamageValue(newDamage);

            if (newDamage >= stack.getMaxDamage()) {
                ItemStack cupStack = new ItemStack(CCFItems.CUP.get());
                
                if (stack.getCount() == 1) {
                    return cupStack;
                } else {
                    stack.shrink(1);
                    if (!player.getInventory().add(cupStack)) {
                        player.drop(cupStack, false);
                    }
                    return stack;
                }
            }
        }
        return stack;
    }

    public int getUseDuration(@Nonnull ItemStack stack) {
        return 32;
    }

    @Override
    @Nonnull
    public UseAnim getUseAnimation(@Nonnull ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    @Nonnull
    @SuppressWarnings("null")
    public InteractionResultHolder<ItemStack> use(@Nonnull Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (stack.getDamageValue() < stack.getMaxDamage()) {
            return ItemUtils.startUsingInstantly(level, player, hand);
        }
        return InteractionResultHolder.pass(stack);
    }

    @Override
    public boolean isBarVisible(@Nonnull ItemStack stack) {
        return true;
    }
}

