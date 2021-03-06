package ca.momoperes.client.io.message.serverbound;

import ca.momoperes.client.io.DynamicSession;
import com.flowpowered.network.Codec;
import com.flowpowered.network.MessageHandler;
import io.netty.buffer.ByteBuf;

import java.io.IOException;

public class S02ConfirmMessageCodec implements Codec<S02ConfirmMessage>, MessageHandler<DynamicSession, S02ConfirmMessage> {

    public S02ConfirmMessage decode(ByteBuf byteBuf) throws IOException {
        int userLength = byteBuf.readInt();
        byte[] userB = byteBuf.readBytes(userLength).array();
        String user = new String(userB);

        int serverLength = byteBuf.readInt();
        byte[] serverB = byteBuf.readBytes(userLength).array();
        String server = new String(serverB);
        return new S02ConfirmMessage(user, server);
    }

    public ByteBuf encode(ByteBuf byteBuf, S02ConfirmMessage s02ConfirmMessage) throws IOException {
        byteBuf.writeInt(s02ConfirmMessage.getUsername().length());
        byteBuf.writeBytes(s02ConfirmMessage.getUsername().getBytes());
        byteBuf.writeInt(s02ConfirmMessage.getServer().length());
        byteBuf.writeBytes(s02ConfirmMessage.getServer().getBytes());
        return byteBuf;
    }

    public void handle(DynamicSession session, S02ConfirmMessage message) {
    }
}
