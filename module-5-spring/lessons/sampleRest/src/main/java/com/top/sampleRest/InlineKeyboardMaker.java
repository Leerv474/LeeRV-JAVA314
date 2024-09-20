package com.top.sampleRest;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class InlineKeyboardMaker {
    InlineKeyboardMaker getLand(String buttonName) {
        InlineKeyboardMaker markup = new InlineKeyboardMaker();
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(getButton())
    }

    List<InlineKeyboardButton> getButton(String text, String callback) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(callback);

        List<InlineKeyboardButton> list = new ArrayList<>();
        list.add(button);
    }
}