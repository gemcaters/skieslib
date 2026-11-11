# SkiesLib

A small NeoForge 1.21.1 library mod for easier registration.

## Add to your mod

`build.gradle`:
```gradle
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation "com.github.gemcaters:skieslib:1.0.0"
}
```

`neoforge.mods.toml`:
```toml
[[dependencies.yourmodid]]
modId = "skieslib"
type = "required"
versionRange = "[1.0.0,)"
ordering = "NONE"
side = "BOTH"
```

## Usage

```java
@Mod("mymod")
public class MyMod {
    public static final SkiesRegistry REG = new SkiesRegistry("mymod");

    public static final DeferredItem<Item> RUBY = REG.item("ruby");
    public static final DeferredBlock<Block> RUBY_BLOCK = REG.block("ruby_block");

    public MyMod(IEventBus modBus) {
        REG.register(modBus);
    }
}
```

## Requirements

- Minecraft 1.21.1
- NeoForge 21.1.x
- Java 21
