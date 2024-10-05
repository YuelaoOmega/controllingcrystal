package com.yuelao.controllingcrystal.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.joml.Matrix4f;

public class TextOverlay {
    private final MinecraftClient client;
    private String message;
    private int time; // 显示的时间

    public TextOverlay(MinecraftClient client) {
        this.client = client;
        this.message = "";
        this.time = 0;
    }

    public void setMessage(String message, int displayTime) {
        this.message = message;
        this.time = displayTime; // 设置显示时间
    }
    public void render(Matrix4f matrices, int screenWidth, int screenHeight) {
        if (time > 0) {
            TextRenderer textRenderer = client.textRenderer;
            int textWidth = textRenderer.getWidth(message);
            int x = (screenWidth - textWidth) / 2; // 居中显示
            int y = screenHeight / 2; // 在屏幕中心
            VertexConsumerProvider vertexConsumers = client.getBufferBuilders().getEntityVertexConsumers(); //顶点消费者

            // 渲染文本
            textRenderer.draw(this.message,x,y,0xFFFAFA,false, matrices, vertexConsumers, TextRenderer.TextLayerType.NORMAL, 0x00000000, 1572);



            time--; // 减少时间
        }
    }
}

