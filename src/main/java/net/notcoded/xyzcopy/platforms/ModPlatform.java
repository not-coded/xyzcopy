package net.notcoded.xyzcopy.platforms;

public interface ModPlatform {
    String getModLoader();
    boolean isModLoaded(String modLoader);
    boolean isDevelopmentEnvironment();
}
