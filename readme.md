# SimulatedLag

## About SimulatedLag

**SimulatedLag** allows you to artificially increase a player's latency by delaying incoming and outgoing packets. This can be useful for testing lag compensation, balancing mechanics, or simulating network issues for debugging purposes.

⚠ **Note:** This plugin may conflict with other plugins that use packets, such as **ProtocolLib** or similar packet-based tools.

## Features
- Introduces a **minimum ping threshold** for players.
- Delays both **incoming and outgoing packets** dynamically.
- Provides a **command-based interface** to control player lag.
- Includes an **API** for developers to integrate simulated lag into their own plugins.

## Commands
| Command                         | Description                                            | Permission           |
|---------------------------------|--------------------------------------------------------|----------------------|
| `/simulatedlag <player> <ping>` | Sets the targeted lag (ping threshold) for the player. | `simulatedlag.admin` |

## API Usage
Developers can interact with **SimulatedLag** through its API:

```java
SimulatedLag plugin = ... // Get the instance of SimulatedLag
plugin.setPlayerTargetedLag(player, 200); // Set 200ms lag
```

### API Methods
| Method                                               | Description                                          |
|------------------------------------------------------|------------------------------------------------------|
| `SimulatedLag#setPlayerTargetedLag(Player, Integer)` | Sets a player's targeted lag threshold (ping in ms). |

## Installation
1. Download the latest version of **SimulatedLag** from [GitHub Releases](https://github.com/bloupyi/SimulatedLag/releases) or a trusted source.
2. Place the `.jar` file in your **plugins/** folder.
3. Configure the plugin using the `config.yml` file.
4. Restart your server.

## Compatibility
- **Minecraft Versions:** 1.18+
- **Dependencies:** None

## Contributing
Contributions are welcome! If you find a bug or have suggestions, feel free to open an issue or submit a pull request on [GitHub](https://github.com/bloupyi/SimulatedLag).

## License
This project is licensed under the [MIT License](LICENSE).

[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-FB287A?logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)
[![Java](https://img.shields.io/badge/Java-007396?logo=openjdk&logoColor=white)](https://www.java.com/)  
[![Contributors](https://img.shields.io/github/contributors/bloupyi/SimulatedLag?color=blue&style=flat)](https://github.com/bloupyi/SimulatedLag/graphs/contributors)
[![Forks](https://img.shields.io/github/forks/bloupyi/SimulatedLag?style=flat)](https://github.com/bloupyi/SimulatedLag/network/members)
[![Stars](https://img.shields.io/github/stars/bloupyi/SimulatedLag?style=flat)](https://github.com/bloupyi/SimulatedLag/stargazers)
[![Issues](https://img.shields.io/github/issues/bloupyi/SimulatedLag?style=flat)](https://github.com/bloupyi/SimulatedLag/issues)
