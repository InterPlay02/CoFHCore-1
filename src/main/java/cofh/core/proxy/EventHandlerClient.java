package cofh.core.proxy;

import cofh.core.init.CoreTextures;
import cofh.core.item.IFOVUpdateItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerClient {

	public static final EventHandlerClient INSTANCE = new EventHandlerClient();

	@SubscribeEvent
	public void handleFOVUpdateEvent(FOVUpdateEvent event) {

		ItemStack stack = event.getEntity().getActiveItemStack();

		if (stack != null && stack.getItem() instanceof IFOVUpdateItem) {
			event.setNewfov(event.getFov() - ((IFOVUpdateItem) stack.getItem()).getFOVMod(stack, event.getEntity()));
		}
	}

	@SubscribeEvent
	public void handleTextureStitchPreEvent(TextureStitchEvent.Pre event) {

		CoreTextures.registerIcons(event.getMap());
	}

}