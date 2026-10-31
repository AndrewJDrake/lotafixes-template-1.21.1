## Immersive Portals Aeronautics
Immersive Portals Aeronautics has a glitch in its mixin to override the behavior of chests across portals. This causes a Chunk-Banning glitch when it runs on the client side of affected items (known: The Brewing Vat from Cultural Delights).

There's a meta-mixin from Mixins Squared at src/main/java/com/lota/fixes/mixin/IPContainerOpenersFix.java that causes the entire mixin to be skipped if there is no server to get information from. This prevents the error entirely.