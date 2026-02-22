<div align="center">

<img src="https://raw.githubusercontent.com/not-coded/xyzcopy/refs/heads/main/src/main/resources/icon.png" width=128 height=128 alt="XYZ Copy Logo"/>
<br>

# XYZ Copy

[![Supports minecraft versions from 1.16](https://notcoded.needs.rest/r/badge_minecraft_1.16plus.svg)](https://minecraft.net) [![Cloth Config API](https://raw.githubusercontent.com/intergrav/devins-badges/v3/assets/cozy/requires/cloth-config-api_vector.svg)](https://www.modrinth.com/mod/cloth-config)

Adds/replaces hotkeys that copies player location and targeted block location.
</div>

## Features
- customizable location templates with placeholders (%x, %y, %z, %yaw, %pitch, %dimension)
- adjustable decimal precision for coordinates
- replaces f3+c debug key with custom location copy
- option to send location in chat instead of clipboard
- configurable copy messages
- supports all minecraft versions from 1.16.5+

## Building
- Clone the repository
  - `git clone https://github.com/not-coded/xyzcopy`
- Run `./gradlew chiseledBuild`