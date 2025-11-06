package fr.cleboost.createcoffeefactory.core;

import com.tterrag.registrate.util.entry.ItemEntry;

import fr.cleboost.createcoffeefactory.CreateCoffeeFactory;
import fr.cleboost.createcoffeefactory.item.CoffeeCupItem;
import fr.cleboost.createcoffeefactory.utils.CCFRegistrate;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
public class CCFItems {
    private static final CCFRegistrate REGISTRATE = CreateCoffeeFactory.registrate();

    // Logo
    public static final ItemEntry<Item> LOGO = REGISTRATE.item("logo", Item::new).lang("Logo")
            .model((ctx, prov) -> {
                prov.generated(ctx, prov.modLoc("item/" + ctx.getName()))
                        .transforms()
                        .transform(ItemDisplayContext.FIXED)
                        .rotation(0, 180, 0)
                        .translation(0, 0, 0.75f)
                        .scale(3, 3, 3)
                        .end();
            })
            .register();

    // Coffee
    public static final ItemEntry<Item> COFFEE_BEAN = REGISTRATE.item("coffee_bean", Item::new).register();
    public static final ItemEntry<Item> COFFEE_BEAN_ROASTED = REGISTRATE.item("coffee_bean_roasted", Item::new).register();
    public static final ItemEntry<Item> COFFEE_POWDER = REGISTRATE.item("coffee_powder", Item::new).register();

    //Cup
    public static final ItemEntry<Item> CUP = REGISTRATE.item("cup", Item::new).register();
    public static final ItemEntry<CoffeeCupItem> COFFEE_CUP = REGISTRATE.item("coffee_cup", CoffeeCupItem::new).register();


    public static void register() {
    }
}
