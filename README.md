<div align="center">

<img src="https://raw.githubusercontent.com/not-coded/xyzcopy/refs/heads/main/src/main/resources/icon.png" width=192 height=192 alt="XYZ Copy Logo"/>
<br>

# XYZ Copy

[![Supports minecraft versions from 1.16](https://notcoded.needs.rest/r/badge_minecraft_1.16plus.svg)](https://minecraft.net) [![Cloth Config API](https://raw.githubusercontent.com/intergrav/devins-badges/v3/assets/cozy/requires/cloth-config-api_vector.svg)](https://www.modrinth.com/mod/cloth-config)

Adds/replaces hotkeys that copies player location and targeted block location.
</div>

## Features
- Player Location Copy
  - Copy the current position with **%x**, **%y**, **%z**, **%yaw**, **%pitch** and **%dimension** placeholders
- Block Location Copy
  - Copy the location of the block you're looking at with **%x**, **%y**, **%z**, **%block** and **%dimension** placeholders

- Keybinds
  - Replace the **F3 + C** debug key with the custom player location copy
  - A keybind for copying the location of the block you're looking at and a keybind for opening the config screen (with support for the F3 modifier)

- Output
  - Copy to clipboard or send locations directly in chat
  - Customizable messages for clipboard and chat 
  - Chat Color support (&a for green, &c for red, etc.)


## Building
- Clone the repository
  - `git clone https://github.com/not-coded/xyzcopy`
- Run `./gradlew chiseledBuild`
