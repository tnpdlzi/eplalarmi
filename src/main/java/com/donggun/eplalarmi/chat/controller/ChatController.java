package com.donggun.eplalarmi.chat.controller;

import com.donggun.eplalarmi.chat.dao.ChatRoom;
import com.donggun.eplalarmi.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/api/v1/chat/create")
    public ChatRoom createRoom(@RequestParam("name") String name) {
        return chatService.createRoom(name);
    }

    @GetMapping("/api/v1/chat")
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }
}
