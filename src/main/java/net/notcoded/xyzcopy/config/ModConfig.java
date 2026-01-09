package net.notcoded.xyzcopy.config;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

public class ModConfig {

    @Comment("Makes the F3 + C debug key combination use the locationTemplate.")
    public boolean replaceDebugKey = true;

    @Comment("The template used when copying the player's location.\nAvailable placeholders: %x, %y, %z, %yaw, %pitch, %dimension")
    public String locationTemplate = "%x %y %z in %dimension";

    @Comment("Number of decimal places to use for the location.")
    public int decimalPlaces = 0;

    @Comment("The message shown when the location is copied to the clipboard.")
    public String copyMessageClipboard = "debug.copy_location.message"; // Vanilla translation key

    @Comment("Send the location in chat instead of copying to the clipboard.")
    public boolean sendInChatInsteadOfCopyingToClipboard = false;

    @Comment("The message shown when the location is shown in chat only\n→ See sendInChatInsteadOfCopyingToClipboard.")
    public String copyMessage = "Copied location";
}
