package net.notcoded.xyzcopy.config;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

public class ModConfig {

    public Location location = new Location();

    public LookingAtBlock block = new LookingAtBlock();

    public static class Location {
        @Comment("Makes the F3 + C debug key combination use the locationTemplate.\nThe Mod Keybind will still work as normal.")
        public boolean replaceDebugKey = true;

        @Comment("The Keybind will only work when F3 is also held down. (e.g. X → F3 + X)\n[!] Beware that this overrides any vanilla debug key combinations using the same key.")
        public boolean useKeybindWithF3 = false;

        @Comment("The template used when copying the player's location.\nAvailable placeholders: %x, %y, %z, %yaw, %pitch, %dimension")
        public String locationTemplate = "%x %y %z";

        @Comment("Number of decimal places to use for the location.")
        public int decimalPlaces = 0;

        @Comment("The message shown when the location is copied to the clipboard.\nYou can use Chat Colors with & codes (e.g. &a for green, &c for red)")
        public String copyMessageClipboard = "Copied location to clipboard";

        @Comment("Send the location in chat instead of copying to the clipboard.")
        public boolean sendInChatInsteadOfCopyingToClipboard = false;

        @Comment("The message shown when the location is shown in chat only\n→ See sendInChatInsteadOfCopyingToClipboard.\nYou can use Chat Colors with & codes (e.g. &a for green, &c for red)")
        public String copyMessage = "Copied location";
    }

    public static class LookingAtBlock {
        @Comment("The Keybind will only work when F3 is also held down. (e.g. X → F3 + X)\n[!] Beware that this overrides any vanilla debug key combinations using the same key.")
        public boolean useKeybindWithF3 = false;

        @Comment("The template used when copying the block location.\nAvailable placeholders: %x, %y, %z, %block, %dimension")
        public String locationTemplate = "%block at %x %y %z";

        @Comment("If fluids should be included when copying the block location.")
        public boolean includeFluids = false;

        @Comment("The message shown when the block location is copied to the clipboard.\nYou can use Chat Colors with & codes (e.g. &a for green, &c for red)")
        public String copyMessageClipboard = "Copied block location to clipboard";

        @Comment("Send the block location in chat instead of copying to the clipboard.")
        public boolean sendInChatInsteadOfCopyingToClipboard = false;

        @Comment("The message shown when the block location is shown in chat only\n→ See sendInChatInsteadOfCopyingToClipboard.\nYou can use Chat Colors with & codes (e.g. &a for green, &c for red)")
        public String copyMessage = "Copied block location";
    }
}
