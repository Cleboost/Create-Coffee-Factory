package fr.cleboost.createcoffeefactory.core;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;


import fr.cleboost.createcoffeefactory.CreateCoffeeFactory;

import java.util.ArrayList;
import java.util.List;

public class CCFLangs {
    public static List<LangEntry> langs = new ArrayList<>();

    // public static final MutableComponent TOOLTIPS_HOLD_SHIFT = LangEntry.withComponent(LangCategory.TOOLTIP, "hold_shift", "Hold [Shift] for information").withStyle(ChatFormatting.DARK_GRAY);


    // public static void holdShiftTooltips(@Nonnull List<Component> tooltip) {
    //     tooltip.add(TOOLTIPS_HOLD_SHIFT);
    // }

    public static void register() {
        for (LangEntry entry : langs) {
            if (!entry.isRegistered()) entry.register();
        }
    }

    public static MutableComponent raw(LangCategory category, String name, Object... args) {
        LangEntry le = new LangEntry(category, name, "");
        return le.getComponent(args);
    }

    public enum LangCategory {
        EMPTY(""),
        TOOLTIP("tooltip"),
        GOGGLE("goggle"),
        MESSAGE("message"),
        COMMANDS("commands",true);
        //PONDER("ponder", true);

        private final String name;
        private final boolean end;

        LangCategory(String name) {
            this.name = name;
            this.end = false;
        }

        LangCategory(String name, boolean end) {
            this.name = name;
            this.end = true;
        }

        public String apply(String namespace) {
            if (end) return namespace + "." + name + ".";
            return name + "." + namespace + ".";
        }
    }

    public static class LangEntry {
        private final String key;
        private final String raw;
        private boolean registered = false;

        public LangEntry(LangCategory category, String name, String raw) {
            this.key = category.apply(CreateCoffeeFactory.MODID) + name;
            this.raw = raw;
            langs.add(this);
        }

        public static MutableComponent withComponent(LangCategory category, String name, String raw) {
            LangEntry le = new LangEntry(category, name, raw);
            return le.register();
        }

        public String getKey() {
            return key;
        }

        public String getRaw() {
            return raw;
        }

        public boolean isRegistered() {
            return this.registered;
        }

        public MutableComponent register() {
            this.registered = true;
            return CreateCoffeeFactory.REGISTRATE.addRawLang(this.key, this.raw);
        }

        public MutableComponent getComponent(Object... args) {
            return Component.translatable(this.key, args);
        }
    }
}
