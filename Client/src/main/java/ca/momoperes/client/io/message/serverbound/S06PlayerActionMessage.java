package ca.momoperes.client.io.message.serverbound;

import ca.momoperes.client.io.message.PlayerAction;
import com.flowpowered.network.Message;

public class S06PlayerActionMessage implements Message {

    private final PlayerAction action;

    public S06PlayerActionMessage(PlayerAction action) {
        this.action = action;
    }

    public PlayerAction getAction() {
        return action;
    }
}
