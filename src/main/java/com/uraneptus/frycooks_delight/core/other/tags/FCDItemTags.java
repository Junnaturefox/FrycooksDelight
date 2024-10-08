package com.uraneptus.frycooks_delight.core.other.tags;

import com.uraneptus.frycooks_delight.FrycooksDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.FarmersDelight;

public class FCDItemTags {

    public static final TagKey<Item> CANOLA_SEEDS = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "seeds/canola"));
    public static final TagKey<Item> CANOLA_CROPS = TagKey.create(Registries.ITEM, new ResourceLocation("forge", "crops/canola"));
    public static final TagKey<Item> OIL_DESTROYS = TagKey.create(Registries.ITEM, FrycooksDelight.modPrefix("oil_destroys"));
    public static final TagKey<Item> BURNS_TO_MORSEL = TagKey.create(Registries.ITEM, FrycooksDelight.modPrefix("burns_to_morsel"));
    public static final TagKey<Item> CAUSE_OIL_OVERFLOW = TagKey.create(Registries.ITEM, FrycooksDelight.modPrefix("cause_oil_overflow"));
    public static final TagKey<Item> IS_FRIED = TagKey.create(Registries.ITEM, FrycooksDelight.modPrefix("is_fried"));
    public static final TagKey<Item> HAS_FISH_SLICE = TagKey.create(Registries.ITEM, FrycooksDelight.modPrefix("has_fish_slice"));
    public static final TagKey<Item> FISH_SLICES = TagKey.create(Registries.ITEM, new ResourceLocation(FarmersDelight.MODID, "fish_slices"));

}
