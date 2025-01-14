package fr.hugman.build_rush;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.hugman.build_rush.game.BRMap;
import net.minecraft.util.Identifier;
import xyz.nucleoid.plasmid.game.common.config.PlayerConfig;

import java.util.List;

public record BRConfig(PlayerConfig playerConfig, BRMap map, List<Identifier> builds) {
	public static final Codec<BRConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			PlayerConfig.CODEC.fieldOf("players").forGetter(BRConfig::playerConfig),
			BRMap.CODEC.fieldOf("map").forGetter(BRConfig::map),
			Identifier.CODEC.listOf().fieldOf("builds").forGetter(BRConfig::builds)
	).apply(instance, BRConfig::new));
}
