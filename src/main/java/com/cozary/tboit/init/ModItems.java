/*
 *
 *  * Copyright (c) 2024 Cozary
 *  *
 *  * This file is part of TBOI Trinkets, a mod made for Minecraft.
 *  *
 *  * TBOI Trinkets is free software: you can redistribute it and/or modify it
 *  * under the terms of the GNU General Public License as published
 *  * by the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * TBOI Trinkets is distributed in the hope that it will be useful, but
 *  * WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * License along with TBOI Trinkets.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.cozary.tboit.init;

import com.cozary.tboit.TboiTrinkets;
import com.cozary.tboit.items.*;
import com.cozary.tboit.items.cards.*;
import com.cozary.tboit.trinkets.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TboiTrinkets.MOD_ID);

    public static final RegistryObject<Item> SOUL_HEART = ITEMS.register("soul_heart", SoulHeartItem::new);
    public static final RegistryObject<Item> RED_HEART = ITEMS.register("red_heart", RedHeartItem::new);
    public static final RegistryObject<Item> ETERNAL_HEART = ITEMS.register("eternal_heart", EternalHeartItem::new);
    public static final RegistryObject<Item> BLACK_HEART = ITEMS.register("black_heart", BlackHeartItem::new);
    public static final RegistryObject<Item> KEY = ITEMS.register("key", ItemBase::new);
    public static final RegistryObject<Item> BOMB = ITEMS.register("bomb", ItemBase::new);
    public static final RegistryObject<Item> PENNY = ITEMS.register("penny", ItemBase::new);

    //Trinkets
    public static final RegistryObject<CurioItemBase> BLUE_BABY = ITEMS.register("blue_baby", BlueBaby::new);
    public static final RegistryObject<CurioItemBase> A_MISSING_PAGE = ITEMS.register("a_missing_page", AMissingPage::new);
    public static final RegistryObject<CurioItemBase> AAA_BATTERY = ITEMS.register("aaa_battery", AAABattery::new);
    public static final RegistryObject<CurioItemBase> ACE_OF_SPADES = ITEMS.register("ace_of_spades", AceOfSpades::new);
    public static final RegistryObject<CurioItemBase> BIBLE_TRACK = ITEMS.register("bible_tract", BibleTrack::new);
    public static final RegistryObject<CurioItemBase> BLACK_LIPSTICK = ITEMS.register("black_lipstick", BlackLipstick::new);
    public static final RegistryObject<CurioItemBase> BLOODY_PENNY = ITEMS.register("bloody_penny", BloodyPenny::new);
    public static final RegistryObject<CurioItemBase> BROKEN_ANKH = ITEMS.register("broken_ankh", BrokenAnkh::new);
    public static final RegistryObject<CurioItemBase> BROKEN_MAGNET = ITEMS.register("broken_magnet", BrokenMagnet::new);
    public static final RegistryObject<CurioItemBase> BROKEN_REMOTE = ITEMS.register("broken_remote", BrokenRemote::new);
    public static final RegistryObject<CurioItemBase> BURN_PENNY = ITEMS.register("burn_penny", BurnPenny::new);
    public static final RegistryObject<CurioItemBase> BUTT_PENNY = ITEMS.register("butt_penny", ButtPenny::new);
    public static final RegistryObject<CurioItemBase> CAINS_EYE = ITEMS.register("cains_eye", CainsEye::new);
    public static final RegistryObject<CurioItemBase> CALLUS = ITEMS.register("callus", Callus::new);
    public static final RegistryObject<CurioItemBase> CANCER = ITEMS.register("cancer", Cancer::new);
    public static final RegistryObject<CurioItemBase> CARTRIDGE = ITEMS.register("cartridge", Cartridge::new);
    public static final RegistryObject<CurioItemBase> CHILDS_HEART = ITEMS.register("childs_heart", ChildsHeart::new);
    public static final RegistryObject<CurioItemBase> COUNTERFEIT_PENNY = ITEMS.register("counterfeit_penny", CounterfeitPenny::new);
    public static final RegistryObject<CurioItemBase> CURSED_SKULL = ITEMS.register("cursed_skull", CursedSkull::new);
    public static final RegistryObject<CurioItemBase> CURVED_HORN = ITEMS.register("curved_horn", CurvedHorn::new);
    public static final RegistryObject<CurioItemBase> DAEMONS_TAIL = ITEMS.register("daemons_tail", DaemonsTail::new);
    public static final RegistryObject<CurioItemBase> EVES_BIRD_FOOT = ITEMS.register("eves_bird_foot", EvesBirdFoot::new);
    public static final RegistryObject<CurioItemBase> FISH_HEAD = ITEMS.register("fish_head", FishHead::new);
    public static final RegistryObject<CurioItemBase> FLAT_PENNY = ITEMS.register("flat_penny", FlatPenny::new);
    public static final RegistryObject<CurioItemBase> FLAT_WORM = ITEMS.register("flat_worm", FlatWorm::new);
    //
    public static final RegistryObject<CurioItemBase> GOAT_HOOF = ITEMS.register("goat_hoof", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> HOOK_WORM = ITEMS.register("hook_worm", HookWorm::new);
    public static final RegistryObject<CurioItemBase> ISAACS_FORK = ITEMS.register("isaacs_fork", IsaacsFork::new);
    public static final RegistryObject<CurioItemBase> ISAACS_HEAD = ITEMS.register("isaacs_head", IsaacsHead::new);
    public static final RegistryObject<CurioItemBase> JUDAS_TONGUE = ITEMS.register("judas_tongue", JudasTongue::new);
    public static final RegistryObject<CurioItemBase> LIBERTY_CAP = ITEMS.register("liberty_cap", LibertyCap::new);
    public static final RegistryObject<CurioItemBase> LUCKY_ROCK = ITEMS.register("lucky_rock", LuckyRock::new);
    public static final RegistryObject<CurioItemBase> LUCKY_TOE = ITEMS.register("lucky_toe", LuckyToe::new);
    public static final RegistryObject<CurioItemBase> MAGGYS_FAITH = ITEMS.register("maggys_faith", MaggysFaith::new);
    public static final RegistryObject<CurioItemBase> MATCH_STICK = ITEMS.register("match_stick", MatchStick::new);
    //
    public static final RegistryObject<CurioItemBase> MISSING_POSTER = ITEMS.register("missing_poster", MissingPoster::new);
    public static final RegistryObject<CurioItemBase> MOMS_PEARL = ITEMS.register("moms_pearl", MomsPearl::new);
    public static final RegistryObject<CurioItemBase> MOMS_TOENAIL = ITEMS.register("moms_toenail", MomsToenail::new);
    public static final RegistryObject<CurioItemBase> MONKEY_PAW = ITEMS.register("monkey_paw", MonkeyPaw::new);
    public static final RegistryObject<CurioItemBase> MYSTERIOUS_CANDY = ITEMS.register("mysterious_candy", MysteriousCandy::new);
    public static final RegistryObject<CurioItemBase> MYSTERIOUS_PAPER = ITEMS.register("mysterious_paper", MysteriousPaper::new);
    public static final RegistryObject<CurioItemBase> PAPER_CLIP = ITEMS.register("paper_clip", PaperClip::new);
    public static final RegistryObject<CurioItemBase> PETRIFIED_POOP = ITEMS.register("petrified_poop", PetrifiedPoop::new);
    public static final RegistryObject<CurioItemBase> PINKY_EYE = ITEMS.register("pinky_eye", PinkyEye::new);
    public static final RegistryObject<CurioItemBase> PULSE_WORM = ITEMS.register("pulse_worm", PulseWorm::new);
    //
    public static final RegistryObject<CurioItemBase> PURPLE_HEART = ITEMS.register("purple_heart", PurpleHeart::new);
    public static final RegistryObject<CurioItemBase> PUSH_PIN = ITEMS.register("push_pin", PushPin::new);
    public static final RegistryObject<CurioItemBase> RED_PATCH = ITEMS.register("red_patch", RedPatch::new);
    public static final RegistryObject<CurioItemBase> RING_WORM = ITEMS.register("ring_worm", RingWorm::new);
    public static final RegistryObject<CurioItemBase> ROSARY_BEAD = ITEMS.register("rosary_bead", RosaryBead::new);
    /*
    public static final RegistryObject<CurioItemBase> RUSTED_KEY = ITEMS.register("rusted_key", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> SAFETY_CAP = ITEMS.register("safety_cap", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> SAMSONS_LOCK = ITEMS.register("samsons_lock", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> STORE_CREDIT = ITEMS.register("store_credit", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> SWALLOWED_PENNY = ITEMS.register("swallowed_penny", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> THE_LEFT_HAND = ITEMS.register("the_left_hand", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> TICK = ITEMS.register("tick", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> UMBILICAL_CORD = ITEMS.register("umbilical_cord", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> WHIP_WORM = ITEMS.register("whip_worm", GoatHoof::new);
    public static final RegistryObject<CurioItemBase> WIGGLE_WORM = ITEMS.register("wiggle_worm", GoatHoof::new);
    */

    //public static final RegistryObject<CurioItemBase> M = ITEMS.register("m", CurioItemBase::new);

    //Cards
    public static final RegistryObject<Item> THE_FOOL = ITEMS.register("the_fool", FoolCard::new);
    public static final RegistryObject<Item> THE_MAGICIAN = ITEMS.register("the_magician", MagicianCard::new);
    public static final RegistryObject<Item> THE_HIGH_PRIESTESS = ITEMS.register("the_high_priestess", HighPriestessCard::new);
    public static final RegistryObject<Item> THE_EMPRESS = ITEMS.register("the_empress", EmpressCard::new);
    public static final RegistryObject<Item> THE_EMPEROR = ITEMS.register("the_emperor", EmperorCard::new);
    public static final RegistryObject<Item> THE_HIEROPHANT = ITEMS.register("the_hierophant", HierophantCard::new);
    public static final RegistryObject<Item> THE_LOVERS = ITEMS.register("the_lovers", LoversCard::new);
    public static final RegistryObject<Item> THE_CHARIOT = ITEMS.register("the_chariot", ChariotCard::new);
    public static final RegistryObject<Item> THE_JUSTICE = ITEMS.register("justice", JusticeCard::new);
    public static final RegistryObject<Item> THE_HERMIT = ITEMS.register("the_hermit", HermitCard::new);
    public static final RegistryObject<Item> THE_WHEEL_OF_FORTUNE = ITEMS.register("wheel_of_fortune", WheelOfFortuneCard::new);
    public static final RegistryObject<Item> STRENGTH = ITEMS.register("strength", StrengthCard::new);
    public static final RegistryObject<Item> THE_HANGED_MAN = ITEMS.register("the_hanged_man", HangedManCard::new);
    public static final RegistryObject<Item> DEATH = ITEMS.register("death", DeathCard::new);
    public static final RegistryObject<Item> TEMPERANCE = ITEMS.register("temperance", TemperanceCard::new);
    public static final RegistryObject<Item> THE_DEVIL = ITEMS.register("the_devil", DevilCard::new);
    public static final RegistryObject<Item> THE_TOWER = ITEMS.register("the_tower", TowerCard::new);
    public static final RegistryObject<Item> THE_STARS = ITEMS.register("the_stars", StarsCard::new);
    public static final RegistryObject<Item> THE_MOON = ITEMS.register("the_moon", MoonCard::new);
    public static final RegistryObject<Item> THE_SUN = ITEMS.register("the_sun", SunCard::new);
    public static final RegistryObject<Item> JUDGEMENT = ITEMS.register("judgement", JudgementCard::new);
    public static final RegistryObject<Item> THE_WORLD = ITEMS.register("the_world", WorldCard::new);

}
